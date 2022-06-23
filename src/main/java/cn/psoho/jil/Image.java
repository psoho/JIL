package cn.psoho.jil;

import lombok.Data;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 图像核心类
 *
 * @author 小新 fastposter@163.com
 */
@Data
public class Image {

    /**
     * 图像尺寸
     */
    public int[] size;
    /**
     * 图像宽度
     */
    public int width;
    /**
     * 图像高度
     */
    public int height;
    /**
     * 图像类型
     */
    public String type = "png";
    /**
     * 画板
     */
    public Graphics2D graphics;
    /**
     * 缓存图片
     */
    BufferedImage im;

    public Image() {
    }

    /**
     * 打开一个图像文件
     *
     * @param path 文件路径
     * @return Image
     */
    @SneakyThrows
    public static Image open(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new ImageException("Can't read input file! " + path);
        }
        return buildImage(ImageIO.read(file));
    }

    /**
     * 构造一个Image对象
     *
     * @param im BufferedImage类型
     * @return Image
     */
    private static Image buildImage(BufferedImage im) {
        Image image = new Image();
        image.im = im;
        image.width = image.im.getWidth();
        image.height = image.im.getHeight();
        image.size = new int[]{image.width, image.height};
        image.graphics = image.im.createGraphics();
        int imageType = im.getType();
        if (imageType == BufferedImage.TYPE_INT_ARGB) {
            image.type = "png";
        } else if (imageType == BufferedImage.TYPE_INT_RGB) {
            image.type = "jpeg";
        }
        System.out.println("type=" + image.im.getType() + ", image.im.getColorModel()=" + image.im.getColorModel());
        return image;
    }

    /**
     * 新建图像
     *
     * @param mode  模式 'RGB', 'RBGA'
     * @param w     宽度
     * @param h     高度
     * @param color 颜色 十六进制，参考CSS颜色设置
     * @return
     */
    public static Image New(String mode, int w, int h, String color) {
        int imageType = BufferedImage.TYPE_INT_ARGB;
        if ("RGB".equalsIgnoreCase(mode)) {
            imageType = BufferedImage.TYPE_INT_RGB;
        }
        BufferedImage im = new BufferedImage(w, h, imageType);
        Graphics2D graphic = im.createGraphics();
        graphic.setColor(ImageColor.getrgb(color));
        graphic.fillRect(0, 0, w, h);
        return buildImage(im);
    }

    /**
     * 显示图像
     */
    public void show() {
        ImageShow.show(this, true);
    }

    /**
     * 显示图像
     *
     * @param delete 是否删除生成的临时文件
     */
    public void show(boolean delete) {
        ImageShow.show(this, delete);
    }

    /**
     * 保存图像
     *
     * @param path 文件路径
     */
    @SneakyThrows
    public void save(String path) {
        ImageIO.write(im, type, new File(path));
    }

    /**
     * 调整图像大小，比例可能失调
     *
     * @param w 宽度
     * @param h 最高度
     */
    public Image resize(int w, int h) {
//        int imageType = this.im.getColorModel().getTransferType() ;
//        if (imageType == 0) {
//            imageType = BufferedImage.TYPE_INT_RGB;
//        }
        BufferedImage newImage = new BufferedImage(w, h, this.im.getType());
        Graphics2D g2d = newImage.createGraphics();
        g2d.drawImage(this.im, 0, 0, w, h, null);
        g2d.dispose();
        return buildImage(newImage);
    }

    /**
     * 缩放，保持图像的高宽比
     *
     * @param w 最大宽度
     * @param h 最大高度
     * @return
     */
    public Image thumbnail(int w, int h) {
        // 计算最大宽度
        double s1 = w / (double) width;
        double s2 = h / (double) height;
        double s = Math.min(s1, s2);    // 获取最小比值
        w = (int) (width * s);
        h = (int) (height * s);
        System.out.println("s1=" + s1 + ", s2=" + s2 + ", s=" + s + ", w=" + w + ", h=" + h + ", width=" + width + ", height=" + height);
        BufferedImage newImage = new BufferedImage(w, h, this.im.getType());
        Graphics2D g2d = newImage.createGraphics();
        g2d.drawImage(this.im, 0, 0, w, h, null);
        g2d.dispose();
        return buildImage(newImage);
    }

}
