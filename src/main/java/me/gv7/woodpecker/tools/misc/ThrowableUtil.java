package me.gv7.woodpecker.tools.misc;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ThrowableUtil {
    /**
     * 获取Throwable详细信息
     *
     * @param throwable
     * @return
     */
    private static String getThrowableInfo(Throwable throwable){
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
        return writer.toString();
    }
}
