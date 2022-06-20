package cn.psoho.jil.viewer;

import lombok.SneakyThrows;

/**
 * Mac OS 图像查看器
 *
 * @author 小新 fastposter@163.com
 */
public class MacViewer implements Viewer {

    /**
     * 初始化
     * 将当前类注册到ImageViewer集合中
     */
    public static void init() {
        viewers.add(new MacViewer());
    }

    /**
     * 显示文件
     *
     * @param path 文件路径
     */
    @SneakyThrows
    @Override
    public void showFile(String path) {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("open", "-a", "Preview.app", path);
        builder.start();
    }

}
