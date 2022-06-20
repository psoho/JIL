package cn.prodapi.jil;

import java.util.Arrays;

public class ImageTest {

    public static void main(String[] args) {
        Image img = Image.open("data/store/leo.jpeg");
        System.out.println(Arrays.toString(img.size));
//        img.show();
//        img.save("ddd.png");

        Image newImg = img.resize(200, 200);
        newImg.show();
    }

}
