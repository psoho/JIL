package cn.psoho.jil;

import lombok.SneakyThrows;

import java.util.Arrays;

public class ImageTest {


    @SneakyThrows
    public static void main(String[] args) {
        // 打开图片
        Image img = Image.open("data/store/leo.jpeg");
        // type=5, image.im.getColorModel()=ColorModel: #pixelBits = 24 numComponents = 3 color space = java.awt.color.ICC_ColorSpace@76fb509a transparency = 1 has alpha = false isAlphaPre = false
        // 显示图片
        img.show();

        // 保存图片
//        img.save("ddd.jpeg");
//        resize(img);
//        thumbnail(img);

        // 新建图片
        // type=2, image.im.getColorModel()=DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=ff000000
//        Image img = Image.New("RGB", 300, 200, "#00ffff");
//        Image img = Image.New("RGBA", 300, 200, "#ff000060");
//        img.show();

//        Image img = Image.open(new FileInputStream("data/store/leo.jpeg"));
//        img.show();

    }

    /**
     * 调整图片尺寸
     *
     * @param img
     */
    private static void resize(Image img) {
        Image newImg = img.resize(200, 200);
//        newImg.show();
    }

    /**
     * 调整图片尺寸，保持高宽比
     *
     * @param img
     */
    private static void thumbnail(Image img) {
        Image newImg2 = img.thumbnail(500, 600);              // [450, 600]
//        Image newImg2 = img.thumbnail(10000, 10000);    // [7500, 10000]
        System.out.println(Arrays.toString(newImg2.size));
//        newImg2.show();
    }

}
