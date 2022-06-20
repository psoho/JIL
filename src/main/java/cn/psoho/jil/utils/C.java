package cn.psoho.jil.utils;

import java.util.UUID;

/**
 * 一些常量和简单的方法封装
 *
 * @author 小新 fastposter@163.com
 */
public class C {

    /**
     * 返回一个随机数16位
     *
     * @return String
     */
    public static String code() {
        return code(16);
    }

    /**
     * 返回一个指定长度的随机数
     *
     * @param len 长度
     * @return String
     */
    public static String code(int len) {
        String text = UUID.randomUUID().toString().replaceAll("-", "");
        if (len < 0 || len > 32) {
            return text;
        }
        return text.substring(0, len);
    }

}
