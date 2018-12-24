package jll.utils;

import java.util.Random;

/**
 * 校验码工具类
 */
public class CheckCodeUtil {

    /**
     *随机生成6位数字符串
     */
    public static String randomVcode(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }


}
