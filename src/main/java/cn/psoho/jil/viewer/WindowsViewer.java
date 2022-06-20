package cn.psoho.jil.viewer;

import lombok.SneakyThrows;

/**
 * Windows 图像查看器
 *
 * @author 小新 fastposter@163.com
 */
public class WindowsViewer implements Viewer {

    public static void init() {
        new WindowsViewer().register();
    }

    @SneakyThrows
    @Override
    public void showFile(String path) {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("start", "JIL", "/WAIT", path);
        builder.start();
    }
    
}
