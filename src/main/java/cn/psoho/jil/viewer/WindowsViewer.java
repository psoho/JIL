package cn.psoho.jil.viewer;

/**
 * Windows 图像查看器
 *
 * @author 小新 fastposter@163.com
 */
public class WindowsViewer implements Viewer {

    public static void init() {
        new WindowsViewer().register();
    }

    @Override
    public void showFile(String path) {

    }
}
