package cn.psoho.jil;

import java.awt.*;

/**
 * 图像颜色
 *
 * @author 小新 fastposter@163.com
 */
public class ImageColor {

    /**
     * 获取颜色
     *
     * @param color 支持CSS十六进制表示
     * @return Color
     */
    public static Color getrgb(String color) {
        color = color.substring(1);  // 去掉#号
        if (color.length() == 6) {
            color += "ff";
        }
        int r = Integer.parseInt(color.substring(0, 2), 16);
        int g = Integer.parseInt(color.substring(2, 4), 16);
        int b = Integer.parseInt(color.substring(4, 6), 16);
        int a = Integer.parseInt(color.substring(6, 8), 16);
        return new Color(r, g, b, a);
    }

}
