package cn.psoho.jil.chapter2;

import cn.psoho.jil.Image;
import cn.psoho.jil.ImageColor;

import java.awt.*;

public class SpirographTest {

    public static void main(String[] args) {

        Image img = Image.New(600, 600);

        Graphics2D g2 = img.graphics; //强制转换为Graphice2D对象

        g2.translate(300, 300);
        g2.setColor(ImageColor.getrgb("#363062"));

        int nPoints = 1000;
        double r1 = 60;
        double r2 = 50;
        double p = 70;

        int x1 = (int) (r1 + r2 - p);
        int y1 = 0;
        int x2;
        int y2;

        for (int i = 0; i < nPoints; i++) {
            double t = i * Math.PI / 90;
            x2 = (int) ((r1 + r2) * Math.cos(t) - p * Math.cos((r1 + r2) * t / r2));
            y2 = (int) ((r1 + r2) * Math.sin(t) - p * Math.sin((r1 + r2) * t / r2));
            g2.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }

        img.show();
    }
}
