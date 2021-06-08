package me.gv7.woodpecker.tools.common;


import me.gv7.woodpecker.tools.common.StreamUtil;

import java.io.*;

public class FileUtil {
    /**
     * 获取文件后缀
     *
     * @param fileName 文件名称
     * @return 文件后缀
     */
    public static String getFileSuffix(String fileName){
        String suffix = null;
        if(fileName.indexOf(".") != -1){
            suffix = fileName.substring(fileName.indexOf("."));
        }
        return suffix;
    }


    /**
     * 读取文件内容
     *
     * @param filePath 文件路径
     * @return 文件内容
     * @throws IOException
     */
    public static byte[] readFile(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        return StreamUtil.readInputStream(fileInputStream);
    }

    /**
     * 写文件
     *
     * @param filePath 文件路径
     * @param bytes 文件内容
     * @throws IOException
     */
    public static void writeFile(String filePath,byte[] bytes) throws IOException{
        OutputStream out = new FileOutputStream(filePath);
        InputStream is = new ByteArrayInputStream(bytes);
        byte[] buff = new byte[1024];
        int len = 0;
        while((len=is.read(buff))!=-1){
            out.write(buff, 0, len);
        }
        is.close();
        out.close();
    }

    /**
     * 拷贝文件
     *
     * @param srcFilePath 原始文件
     * @param desFilePath 目标文件
     * @throws IOException
     */
    private static void copyFile(String srcFilePath, String desFilePath) throws IOException {
        byte[] fileContent = readFile(srcFilePath);
        writeFile(desFilePath,fileContent);
    }

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return 是否删除成功
     */
    private static boolean deleteFile(String filePath){
        File file = new File(filePath);
        return file.delete();
    }
}
