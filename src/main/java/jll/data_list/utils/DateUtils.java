package jll.data_list.utils;


import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    /**
     * 根据数字日期格式得到日期
     * */
    public static Date StringToDate(String date){
        if(date==null||date.equals("")){
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date time=null;
        try {
            time=sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
    /**
     * num前n年
     * 获取当前年份
     * */
    public static Integer getYear(Integer num) {
        //当前年份
        Calendar now = Calendar.getInstance();
        int year=now.get(Calendar.YEAR);
        //前年年份
        int date=year-num;
        return date;
    }
    //日期转字符串
    public static String DateToStringForNumber(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time=null;
        time=sdf.format(date);
        return time;
    }

}
