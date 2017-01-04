package com.example.administrator.myapplication.utils;

import java.security.MessageDigest;

/**
 * Created on 2016/10/9.
 * Author：qdq
 * Description:MD5加密 MD5转url
 */
public class MD5 {
    public final static String getMessageDigest(byte[] buffer) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取图片的url
     *
     * @param md5
     * @return
     */
    public final static String geturl(String md5) {
        return "http://show-static-image.wopu.me/" + md5 + "@.gif";
    }
}
