package cn.psoho.jil;

import java.util.Arrays;

public class ImageTest {

    public static void main(String[] args) {
        // 打开图片
        Image img = Image.open("data/store/leo.jpeg");

//         显示图片
//        img.show();

        // 保存图片
//        img.save("ddd.jpeg");

        // 调整图片尺寸
//        Image newImg = img.resize(200, 200);
//        newImg.show();

        // 压缩图片，保持高宽比
//        Image newImg2 =img.thumbnail(200, 200);
//        Image newImg2 = img.thumbnail(500, 600);              // [450, 600]
        Image newImg2 = img.thumbnail(10000, 10000);    // [7500, 10000]
        System.out.println(Arrays.toString(newImg2.size));
        newImg2.show();

    }

}
