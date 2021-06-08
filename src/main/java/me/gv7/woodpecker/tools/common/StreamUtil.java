package me.gv7.woodpecker.tools.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
    /**
     * 从数据流中读取数据
     *
     * @param inputStream 数据流
     * @return 数据流中的数据
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] cache = new byte[1024];
        int nRead = 0;
        while ((nRead = inputStream.read(cache)) != -1) {
            out.write(cache, 0, nRead);
            out.flush();
        }
        out.close();
        inputStream.close();
        return out.toByteArray();
    }
}
