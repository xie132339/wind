package com.wind.comm.util.data;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {
    public static final String YYYY_M_D = "yyyy-M-d";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HHMM = "yyyy-MM-dd HHmm";
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddhhmmssSSS";
    public static final String YYYY_MM_DD_HH_MM_SSSSS = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HH_mm = "HH:mm";
    public static final String M_YUE_DD_RI = "M月dd日";
    public static final String YYYY_NIAN_MM_YUE_DD_RI_HH_MM = "yyyy年MM月dd日 HH:mm";
    public static final String YYYY_NIAN_MM_YUE_DD_RI = "yyyy年MM月dd日";
    public static final String DDMMYY_HHMMSS = "dd/MM/yyyy HH:mm:ss";
    public static final String YYMMDD_HHMMSS = "yyyy/MM/dd HH:mm:ss";
    public static final String YYYY__MM__DD = "yyyy/MM/dd";
    public static final String MMDDYY = "MM/dd/yyyy";
    public static final String INIT_DATE = "1970-1-1";
    public static final String INIT_DATE_ZERO = "1970-01-01";
    public static final String HH_mm_ss = "HH:mm:ss";
    public static final String HH_mm_ss_SSS = "HH:mm:ss SSS";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String PATTERN_yyyy_MM_dd = "yyyy-MM-dd";
    public static final String PATTERN_yyyyMMdd = "yyyyMMdd";
    public static final String PATTERN_MMdd = "MM-dd";
    public static final String PATTERN_yyMMdd = "yy/MM/dd";
    public static final String PATTERN_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String PATTERN_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String PATTERN_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_HH_mm_ss = "HH:mm:ss";
    public static final String PATTERN_HHmmss = "HHmmss";
    public static final String PATTERN_yyyyMMdd_HHmmss = "yyyy/MM/dd HH:mm:ss";
    public static final String PATTERN_yyyyMMdd2 = "yyyy/MM/dd";

    public static String[] MONTHS = new String[]{"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};

    private static int[] DOMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] lDOMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final Map<String, String> weekDays = new HashMap<String, String>();

    static {
        weekDays.put("monday", "星期一");
        weekDays.put("tuesday", "星期二");
        weekDays.put("wednesday", "星期三");
        weekDays.put("thursday", "星期四");
        weekDays.put("friday", "星期五");
        weekDays.put("saturday", "星期六");
        weekDays.put("sunday", "星期日");
    }

    /**
     * String换成Date类型
     *
     * @param sDate   2019-01-07 00:00:00
     * @param pattern 转换格式 比如 yyyy-MM-dd HH:mm:ss
     * @return date
     */
    public static Date parseDate(String sDate, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        if (StringUtils.isNotEmpty(sDate)) {
            try {
                return format.parse(sDate);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * Date转换成String格式
     *
     * @param sDate     Date日期
     * @param formatStr 转换格式 比如 yyyy-MM-dd HH:mm:ss
     * @return str
     */
    public static String formatDate(Date sDate, String formatStr) {
        if (sDate == null)
            return "";
        DateFormat format = new SimpleDateFormat(formatStr);
        return format.format(sDate);
    }

    /**
     * 10位或者13位 时间戳转换成String
     *
     * @param timestamp 1525849325942 或者 1556249753
     * @param formatStr 转换格式 比如 yyyy-MM-dd HH:mm:ss
     * @return str
     */
    public static String formatTimestamp(String timestamp, String formatStr) {
        DateFormat format = new SimpleDateFormat(formatStr);
        if (timestamp == null)
            return "";
        if (timestamp.length() == 10) {
            return format.format(new Date(Long.parseLong(timestamp)));
        } else if (timestamp.length() == 13) {
            return format.format(new Date(Long.parseLong(timestamp)));
        }
        return "";
    }

    /**
     * 判断是否是日期数据
     * @param dateStr "2019-10-32" or "2019/10/32"
     * @param pattern 日期格式 yyyy-MM-dd 要与 dateStr格式一致
     * @return boolean
     */
    public static boolean isValidDate(String dateStr, String pattern) {
        return formatDate(parseDate(dateStr, pattern), pattern).equals(dateStr);
    }

    /**
     * 当前日期增加分钟
     * @param date 日期
     * @param amount 增加多少分钟 例子：20
     * @return
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 当前日期增加小时
     * @param date 日期
     * @param amount 增加多少小时 例子：20
     * @return
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 当前日期增加天数
     * @param date 日期
     * @param amount 增加多少小时 例子：20
     * @return
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 
     * @param date 时间
     * @param calendarField 格式： 年（ Calendar.YEAR）、月（Calendar.MONTH）、日（Calendar.DATE）、
     * 时（24小时制：Calendar.HOUR_OF_DAY、12小时制：Calendar.HOUR）、分（Calendar.MINUTE）、秒（Calendar.SECOND）
     * 传入    Calendar.YEAR   则需要增加多少年
     * @param amount 新增的数据 如： 2
     * @return Date
     */
    public static Date add(Date date, int calendarField, Integer amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (amount == null) {
            throw new IllegalArgumentException("The amount must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    
    /**
     * 
     * @param date 时间
     * @param calendarField 格式： 年（ Calendar.YEAR）、月（Calendar.MONTH）、日（Calendar.DATE）、
     * 时（24小时制：Calendar.HOUR_OF_DAY、12小时制：Calendar.HOUR）、分（Calendar.MINUTE）、秒（Calendar.SECOND）
     * 传入    Calendar.YEAR   则需要减加多少年
     * @param amount
     * @return
     */
    public static Date subtract(Date date, int calendarField, Integer amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (amount == null) {
            throw new IllegalArgumentException("The amount must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, - amount);
        return c.getTime();
        
    }

    /**
     * 统计两个日期相差多少天
     *
     * @param time1 2019-04-10
     * @param time2 2019-04-04
     * @return 6
     */
    public static long getDateDiffByDay(String time1, String time2) {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat(YYYY_MM_DD);
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quot;
    }

    public static void main(String[] args) {
        
        String timeStr = DateUtils.formatDate(DateUtils.subtract(new Date(), Calendar.MINUTE, 2), DateUtils.YYYY_MM_DD_HH_MM_SS);
        System.out.println(timeStr); 
        System.out.println(DateUtils.isValidDate("2019-10-32", DateUtils.YYYY_MM_DD));

        String date2 = "Mon Oct 28 00:00:00 CST 2019";
        String date1 = "Sun Apr 28 00:00:00 CST 2019";
        String str = date1.substring(0, 3);
        System.out.println(str);

        System.out.println(DateUtils.formatTimestamp("1556420745081", "yyyy/MM/dd"));
    }
}
