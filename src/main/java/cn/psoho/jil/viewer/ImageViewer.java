package cn.psoho.jil.viewer;


import cn.psoho.jil.Image;
import cn.psoho.jil.utils.C;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface ImageViewer {

    List<ImageViewer> viewers = new ArrayList<>();

    static void show(Image image) {
        if (viewers.size() <= 0) {
            return;
        }
        // 生成临时文件
        String path = System.getProperty("java.io.tmpdir") + C.code() + ".png";
        System.out.println("path=" + path);
        image.save(path);

        // 调用查看
        viewers.forEach(v -> {
            v.showFile(path);
        });

        // 删除临时文件
        // 20秒后删除
        new File(path).deleteOnExit();
    }

    void showFile(String path);
}
