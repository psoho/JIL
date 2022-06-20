package cn.prodapi.jil.viewer;

import lombok.SneakyThrows;

public class MacImageViewer implements ImageViewer {

    public static void init() {
        ImageViewer.viewers.add(new MacImageViewer());
    }

    @SneakyThrows
    @Override
    public void showFile(String path) {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("open", "-a", "Preview.app", path);
        builder.start();
    }

}
