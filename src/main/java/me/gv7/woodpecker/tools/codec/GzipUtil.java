package me.gv7.woodpecker.tools.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtil {
    /**
     * Gzip压缩
     *
     * @param bytes 要压缩的数据
     * @return Gzip压缩Base64编码数据
     * @throws IOException
     */
    public static String compress(byte[] bytes) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        GZIPOutputStream gos = new GZIPOutputStream(os);
        gos.write(bytes);
        gos.close();
        byte[] compressed = os.toByteArray();
        os.close();
        return new BASE64Encoder().encode(compressed);
    }


    /**
     * Gzip解压
     *
     * @param strEncode Gzip压缩数据
     * @return 解压结果
     * @throws IOException
     */
    public static byte[] decompress(String strEncode) throws IOException {
        byte[] compressed = new BASE64Decoder().decodeBuffer(strEncode);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(compressed);
        GZIPInputStream gis  = new GZIPInputStream(inputStream);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = gis.read(data)) != -1) {
            baos.write(data, 0, bytesRead);
        }
        return baos.toByteArray();
    }
}
