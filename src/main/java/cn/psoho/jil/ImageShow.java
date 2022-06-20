package cn.psoho.jil;

import cn.psoho.jil.viewer.ImageViewer;
import cn.psoho.jil.viewer.MacImageViewer;

public class ImageShow {

    static {

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith("mac")) {
            MacImageViewer.init();
        }

    }

    // 显示图片
    public static void show(Image image) {
        // 保存图片
        ImageViewer.show(image);
    }

}
