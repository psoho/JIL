package cn.psoho.jil;

import cn.psoho.jil.viewer.MacViewer;
import cn.psoho.jil.viewer.Viewer;

/**
 * 图像显示器
 *
 * @author 小新 fastposter@163.com
 */
public class ImageShow {

    static {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith("mac")) {
            MacViewer.init();
        }
    }

    /**
     * 显示图像
     *
     * @param image
     */
    public static void show(Image image) {
        Viewer.show(image);
    }

}
