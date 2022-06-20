package cn.psoho.jil;

import cn.psoho.jil.viewer.ImageViewer;
import cn.psoho.jil.viewer.MacImageViewer;

/**
 * 图像显示器
 *
 * @author 小新 fastposter@163.com
 */
public class ImageShow {

    static {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith("mac")) {
            MacImageViewer.init();
        }
    }

    /**
     * 显示图像
     *
     * @param image
     */
    public static void show(Image image) {
        ImageViewer.show(image);
    }

}
