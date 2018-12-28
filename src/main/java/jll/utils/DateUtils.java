package jll.utils;


import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    //生成日期为二〇一八年五月三十日
    public static String DateToCN(Date date) {
        if (null == date || "".equals(date)) {
            return null;
        }
        String[] CN = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        StringBuffer cn = new StringBuffer();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        for (int i = 0; i < year.length(); i++) {
            cn.append(CN[year.charAt(i) - 48]);
        }
        cn.append("年");
        int mon = calendar.get(Calendar.MONTH) + 1;
        if (mon < 10) {
            cn.append(CN[mon]);
        } else if (mon < 20) {
            if (mon == 10) {
                cn.append("十");
            } else {
                cn.append("十").append(CN[mon % 10]);
            }
        }
        cn.append("月");
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (day < 10) {
            cn.append(CN[day]);
        } else if (day < 20) {
            if (day == 10) {
                cn.append("十");
            } else {
                cn.append("十").append(CN[day % 10]);
            }
        } else if (day < 30) {
            if (day == 20) {
                cn.append("二十");
            } else {
                cn.append("二十").append(CN[day % 10]);
            }
        } else {
            if (day == 30) {
                cn.append("三十");
            } else {
                cn.append("三十").append(CN[day % 10]);
            }
        }
        cn.append("日");
        return cn.toString();
    }
    //生成日期的格式为2018年5月30日
    public static String DateToNum(Date date) {
        if (null == date || "".equals(date)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String time = format.format(date.getTime());// 这个就是把时间戳经过处理得到期望格式的时间
        return time;
    }
    //生成日期格式为2018年5月30日00:00:00
    public static String DateToHms(Date date) {
        if (null == date || "".equals(date)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String time = format.format(date.getTime());// 这个就是把时间戳经过处理得到期望格式的时间
        return time;
    }

    //生成日期格式为2018
    public static String DateToYear(Date date) {
        if (null == date || "".equals(date)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String time = format.format(date.getTime());// 这个就是把时间戳经过处理得到期望格式的时间
        return time;
    }
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
