package com.wind.comm.util;

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

    public static Date parseCnDate(String sDate) {
        return parseDate(sDate, YYYY_NIAN_MM_YUE_DD_RI);
    }

    public static Date parseDate(String sDate) {
        return parseDate(sDate, YYYY_MM_DD);
    }

    public static Date parseDate4Xls(String sDate) {
        return parseDate(sDate, YYYY__MM__DD);
    }

    public static Date parseCnHmDate(String sDate) {
        return parseDate(sDate, YYYY_MM_DD_HH_MM_SS);
    }

    public static Date parseHhDate(String sDate) {
        return parseDate(sDate, YYYY_MM_DD_HH);
    }

    public static String formatDateByFormat(Date sDate, String Format) {
        return formatDate(sDate, Format);
    }

    public static String formatDateYYYYMMDD(Date sDate) {
        return formatDate(sDate, YYYYMMDD);
    }

    public static String formatDate(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD);
    }

    public static String formatTime(Date sDate) {
        return formatDate(sDate, HH_mm_ss);
    }

    public static String formatTimeMillisecond(Date sDate) {
        return formatDate(sDate, HH_mm_ss_SSS);
    }

    public static String formatCnDate(Date sDate) {
        return formatDate(sDate, YYYY_NIAN_MM_YUE_DD_RI);
    }

    public static String formatCnHmDate(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH_MM_SS);
    }

    public static String formatHhMmDate(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH_MM);
    }

    public static String formatHhDate(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH);
    }

    public static String formatCnHmDateS(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH_MM_SSSSS);
    }

    public static String formatHmDate(Date sDate) {
        return formatDate(sDate, HH_mm);
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

    public static String defaultFormatDate(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH_MM_SS);
    }

    public static boolean isValidDate(String dateStr, String pattern) {
        return formatDate(parseDate(dateStr, pattern), pattern).equals(dateStr);
    }

    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    public static String formatDateHour(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH_MM);
    }

    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * Calendar 的“年、月、日、星期、时、分、秒”这些信息，一共是17个字段。
     * 我们使用Calendar，无非是就是使用这17个字段。它们的定义如下：
     * (字段0) public final static int ERA = 0;
     * 说明：纪元。
     * 取值：只能为0 或 1。0表示BC(“before Christ”,即公元前)，1表示AD(拉丁语“Anno Domini”,即公元)。
     * <p>
     * (字段1) public final static int YEAR = 1;
     * 说明：年。
     * <p>
     * (字段2) public final static int MONTH = 2;
     * 说明：月
     * 取值：可以为，JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER, UNDECIMBER。
     * 其中第一个月是 JANUARY，它为 0。
     * <p>
     * (字段3) public final static int WEEK_OF_YEAR = 3;
     * (字段4) public final static int WEEK_OF_MONTH = 4;
     * 说明：当前日期在本月中对应第几个星期。一个月中第一个星期的值为 1。
     * <p>
     * (字段5) public final static int DATE = 5;
     * 说明：日。一个月中第一天的值为 1。
     * <p>
     * (字段5) public final static int DAY_OF_MONTH = 5;
     * 说明：同“DATE”，表示“日”。
     * <p>
     * (字段6) public final static int DAY_OF_YEAR = 6;
     * 说明：当前日期在本年中对应第几天。一年中第一天的值为 1。
     * <p>
     * (字段7) public final static int DAY_OF_WEEK = 7;
     * 说明：星期几。
     * 取值：可以为，SUNDAY、MONDAY、TUESDAY、WEDNESDAY、THURSDAY、FRIDAY 和 SATURDAY。
     * 其中，SUNDAY为1，MONDAY为2，依次类推。
     * <p>
     * (字段8) public final static int DAY_OF_WEEK_IN_MONTH = 8;
     * 说明：当前月中的第几个星期。
     * <p>
     * (字段9) public final static int AM_PM = 9;
     * 说明：上午 还是 下午
     * 取值：可以是AM 或 PM。AM为0,表示上午；PM为1,表示下午。
     * <p>
     * (字段10) public final static int HOUR = 10;
     * 说明：指示一天中的第几小时。
     * HOUR 用于 12 小时制时钟 (0 - 11)。中午和午夜用 0 表示，不用 12 表示。
     * <p>
     * (字段11) public final static int HOUR_OF_DAY = 11;
     * 说明：指示一天中的第几小时。
     * HOUR_OF_DAY 用于 24 小时制时钟。例如，在 10:04:15.250 PM 这一时刻，HOUR_OF_DAY 为 22。
     * <p>
     * (字段12) public final static int MINUTE = 12;
     * 说明：一小时中的第几分钟。
     * 例如，在 10:04:15.250 PM这一时刻，MINUTE 为 4。
     * <p>
     * (字段13) public final static int SECOND = 13;
     * 说明：一分钟中的第几秒。
     * 例如，在 10:04:15.250 PM 这一时刻，SECOND 为 15。
     * <p>
     * (字段14) public final static int MILLISECOND = 14;
     * 说明：一秒中的第几毫秒。
     * 例如，在 10:04:15.250 PM 这一时刻，MILLISECOND 为 250。
     * <p>
     * (字段15) public final static int ZONE_OFFSET = 15;
     * 说明：毫秒为单位指示距 GMT 的大致偏移量。
     * <p>
     * (字段16) public final static int DST_OFFSET = 16;
     * 说明：毫秒为单位指示夏令时的偏移量。
     * <p>
     * public final static int FIELD_COUNT = 17;
     * 这17个字段是保存在int数组中。定义如下：
     *
     * @param date
     * @param calendarField
     * @param amount
     * @return
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
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

        String date2 = "Mon Oct 28 00:00:00 CST 2019";
        String date1 = "Sun Apr 28 00:00:00 CST 2019";
        String str = date1.substring(0, 3);
        System.out.println(str);

        System.out.println(DateUtils.formatTimestamp("1556420745081", "yyyy/MM/dd"));
    }
}
