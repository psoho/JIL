package cn.psoho.jil.viewer;


import cn.psoho.jil.Image;
import cn.psoho.jil.utils.C;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 图像查看器
 *
 * @author 小新 fastposter@163.com
 */
public interface Viewer {

    /**
     * 图像查看器集合
     */
    List<Viewer> viewers = new ArrayList<>();

    /**
     * 显示一个Image对象
     *
     * @param image Image类
     */
    static void show(Image image) {
        if (viewers.size() <= 0) {
            return;
        }
        // 生成临时文件
        String path = System.getProperty("java.io.tmpdir") + C.code() + ".png";
        image.save(path);

        // 调用查看
        viewers.forEach(v -> {
            v.showFile(path);
        });

        // 删除临时文件
        // 20秒后删除
        new File(path).deleteOnExit();
    }

    /**
     * 显示指定的图像文件
     *
     * @param path
     */
    void showFile(String path);
}
