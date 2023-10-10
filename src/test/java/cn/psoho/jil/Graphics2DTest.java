package cn.psoho.jil;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Graphics2DTest {

    public static void main(String[] args) {

        Image img = Image.New(600, 600);

        Graphics2D g2 = img.graphics; //强制转换为Graphice2D对象


//        消文字锯齿：RenderingHints.KEY_TEXT_ANTIALIASING
//        消绘图锯齿：RenderingHints.KEY_ANTIALIASING

        // 画线平滑
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);

        // 恢复默认
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
//        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);


        g2.setColor(Color.blue);
        Ellipse2D e = new Ellipse2D.Double(-100, -50, 200, 100);
        AffineTransform tr = new AffineTransform();
        tr.rotate(Math.PI / 6.0);

        // 设置旋转变换
        Shape shape = tr.createTransformedShape(e);
        g2.translate(300, 200);

        //进行平移变换
        g2.scale(2, 2); //进行缩成变换
//        g2.draw(shape);
        g2.fill(shape);
        //绘制可雄转的椭園
        g2.drawString("Hello 2D", 0, 0);

        img.show();


    }
}
