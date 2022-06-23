package cn.psoho.jil.viewer;


import cn.psoho.jil.Image;
import cn.psoho.jil.ImageException;
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
     * 注册到图像查看器
     */
    default void register() {
        viewers.add(this);
    }

    /**
     * 显示一个Image对象
     *
     * @param image  Image类
     * @param delete
     */
    static void show(Image image, boolean delete) {
        if (viewers.size() <= 0) {
            throw new ImageException("No available viewer!");
        }
        // 生成临时文件
        String path = System.getProperty("java.io.tmpdir") + C.code() + "." + image.getType();
        image.save(path);

        // 调用查看
        viewers.forEach(v -> {
            v.showFile(path);
        });

        if (delete) {
            // 删除临时文件
            // 20秒后删除
            new File(path).deleteOnExit();
        }
    }

    /**
     * 显示指定的图像文件
     *
     * @param path
     */
    void showFile(String path);
}
