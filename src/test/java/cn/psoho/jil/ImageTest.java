package cn.psoho.jil;

public class ImageTest {

    public static void main(String[] args) {
        // 打开图片
        Image img = Image.open("data/store/leo.jpeg");

        // 显示图片
//        img.show();

        // 保存图片
//        img.save("ddd.jpeg");

        // 调整图片尺寸
        Image newImg = img.resize(200, 200);
        newImg.show();
    }

}
