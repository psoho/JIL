package cn.prodapi.jil;

import lombok.Data;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@Data
public class Image {

    public int[] size;
    public int width;
    public int height;
    public String type = "png";
    public Graphics2D graphics;

    BufferedImage im;

    public Image() {

    }

    @SneakyThrows
    public static Image open(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new ImageException("Can't read input file! " + path);
        }
        return buildImage(ImageIO.read(file));
    }

    private static Image buildImage(BufferedImage im) {
        Image image = new Image();
        image.im = im;
        image.width = image.im.getWidth();
        image.height = image.im.getHeight();
        image.size = new int[]{image.width, image.height};
        image.graphics = image.im.createGraphics();
        System.out.println("type=" + image.im.getType() + ", image.im.getColorModel()=" + image.im.getColorModel());
        return image;
    }

    public void show() {
        ImageShow.show(this);
    }

    @SneakyThrows
    public void save(String path) {
        ImageIO.write(im, type, new File(path));
    }

    /**
     * 调整图像大小，比例可能失调
     *
     * @param w 最大宽度
     * @param h 最大高度
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

}
