package me.gv7.woodpecker.tools.codec;

public class UnicodeUtil {
    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            String tmp = Integer.toHexString(c);

            String unicodeU = "u";
            if (tmp.length() >= 4) {
                unicode.append(unicodeU + Integer.toHexString(c));
            } else if (tmp.length() == 3){
                unicode.append(unicodeU + "0" + Integer.toHexString(c));
            } else if (tmp.length() == 2){
                unicode.append(unicodeU + "00" + Integer.toHexString(c));
            } else if (tmp.length() == 1){
                unicode.append(unicodeU + "000" + Integer.toHexString(c));
            } else if (tmp.length() == 3){
                unicode.append(unicodeU + "0000");
            }
        }
        return unicode.toString();
    }
}



