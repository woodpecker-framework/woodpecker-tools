package me.gv7.woodpecker.tools.codec;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class URLCodeUtil {
    public static String decode(String s){
        return URLDecoder.decode(s);
    }

    public static String decode(String s,String enc) throws UnsupportedEncodingException {
        return URLDecoder.decode(s,enc);
    }

    public static String encode(String s) {
        return URLEncoder.encode(s);
    }

    public static String encode(String s,String enc) throws UnsupportedEncodingException {
        return URLEncoder.encode(s,enc);
    }

    public static String encodeAllChars(String string) {
        char[] chars = string.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : chars) {
            hex.append("%" + Integer.toHexString(ch));
        }
        return hex.toString();
    }

    public static String encodeAllUnicodeChars(String string) throws UnsupportedEncodingException {
        String str = UnicodeUtil.string2Unicode(string);
        return str.replace("u","%u");
    }
}
