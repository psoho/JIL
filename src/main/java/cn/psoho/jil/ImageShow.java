package cn.psoho.jil;

import cn.psoho.jil.viewer.MacViewer;
import cn.psoho.jil.viewer.Viewer;
import cn.psoho.jil.viewer.WindowsViewer;

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
        if(osName.startsWith("windows")){
            WindowsViewer.init();
        }
    }

    /**
     * 显示图像
     *
     * @param image
     * @param delete
     */
    public static void show(Image image, boolean delete) {
        Viewer.show(image, delete);
    }

}
