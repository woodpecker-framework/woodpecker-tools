package me.gv7.woodpecker.tools.misc;


import java.util.Random;

public class RandomUtil {
    public static String getRandomString(String base,int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    public static String getRandomString(int length){
        String base = "abcdefghijklmnopqrstuvwxyz";
        return getRandomString(base,length);
    }


    public static int getRandomNumber(int length){
        String base = "0123456789";
        return Integer.valueOf(getRandomString(base,length));
    }
}
