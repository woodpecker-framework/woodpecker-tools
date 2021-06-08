package me.gv7.woodpecker.tools.codec;

/**
 * Reference: https://www.cnblogs.com/xiaoyaogege/p/6306689.html
 */
public class HexUtil {
    /**
     * hex编码
     *
     * @param src 要编码的数据
     * @return 编码结果
     */
    public static String encode(byte[] src) {
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < src.length; n++) {
            strHex = Integer.toHexString(src[n] & 0xFF);
            // 每个字节由两个字符表示，位数不够，高位补0
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex);
        }
        return sb.toString().trim();
    }

    /**
     * hex解码
     *
     * @param src 要解码的数据
     * @return 解码结果
     */
    public static byte[] decode(String src) {
        int m = 0, n = 0;
        // 每两个字符描述一个字节
        int byteLen = src.length() / 2;
        byte[] ret = new byte[byteLen];
        for (int i = 0; i < byteLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            int intVal = Integer.decode("0x" + src.substring(i * 2, m) + src.substring(m, n));
            ret[i] = Byte.valueOf((byte)intVal);
        }
        return ret;
    }
}
