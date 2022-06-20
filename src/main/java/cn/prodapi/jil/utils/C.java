package cn.prodapi.jil.utils;

import java.util.UUID;

public class C {

    public static String code() {
        return code(16);
    }

    public static String code(int len) {
        String text = UUID.randomUUID().toString().replaceAll("-", "");
        if (len < 0 || len > 32) {
            return text;
        }
        return text.substring(0, len);
    }

}
