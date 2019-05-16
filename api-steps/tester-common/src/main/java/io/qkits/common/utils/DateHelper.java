//package io.qkits.common.utils;
//
//import org.apache.commons.lang3.time.DateFormatUtils;
//import org.apache.commons.lang3.time.DateUtils;
//import org.apache.commons.lang3.tuple.ImmutableTriple;
//import org.apache.commons.lang3.tuple.Triple;
//import org.joda.time.DateTime;
//
//
//import java.text.ParseException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//import java.util.Calendar;
//import java.util.Date;
//
//
///**
// * @version $Id$
// */
//
//
//public class DateHelper {
//
//    private DateHelper() {
//    }
//
//    /**
//     * format Date,根据输入的Patter 格式化时间
//     *
//     * @param date
//     * @param pattern 格式化的pattern
//     * @return
//     */
//    public static String formatDate(Date date, String pattern) {
//        return DateFormatUtils.format(date, pattern);
//
//    }
//
//
//    /**
//     * 格式话当天时间,返回格式是: YYYY-MM-DD
//     *
//     * @return
//     */
//    public static String formatCurrentDate() {
//
//        return formatDate(new Date(), 0);
//    }
//
//
//
//    /**
//     * 根据小时/分钟/秒生成日期Calendar 对象
//     *
//     * @param hour
//     * @param minute
//     * @param second
//     * @return
//     */
//    public static Calendar buildCalendarDate(int hour, int minute, int second) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.HOUR_OF_DAY, hour);
//        cal.set(Calendar.MINUTE, minute);
//        cal.set(Calendar.SECOND, second);
//        cal.set(Calendar.MILLISECOND, 0);
//        return cal;
//    }
//
//
//    /**
//     * convert to date from long value
//     *
//     * @param time
//     * @return
//     */
//    public static Date convertFromLong(long time) {
//        return new Date(time);
//    }
//
//    /**
//     * is same date
//     *
//     * @param date1
//     * @param date2
//     * @return
//     */
//    public static boolean isSameDate(Calendar date1, Calendar date2) {
//        return DateUtils.isSameDay(date1, date2);
//    }
//
//    /**
//     * is same date
//     *
//     * @param date1
//     * @param date2
//     * @return
//     */
//    public static boolean isSameDate(Date date1, Date date2) {
//        return DateUtils.isSameDay(date1, date2);
//    }
//
//    /**
//     * format date
//     *
//     * @param date
//     * @return
//     */
//    public static String formatISODateTime(Date date) {
//        return DateFormatUtils.ISO_DATETIME_FORMAT.format(date);
//    }
//
//    /**
//     * formate date
//     *
//     * @param date
//     * @return
//     * @throws ParseException
//     */
//    public static String formatISODateTime(String date) throws ParseException {
//        return DateFormatUtils.ISO_DATETIME_FORMAT.format(convertToDateTimeFormat(date));
//    }
//
//    /**
//     * convert date to date_time format
//     *
//     * @param date
//     * @return
//     * @throws ParseException
//     */
//    public static Date convertToDateTimeFormat(String date) throws ParseException {
//        return DateFormatUtils.ISO_DATETIME_FORMAT.parse(date);
//    }
//
//    /**
//     * covert string to Date time format
//     *
//     * @param date
//     * @return
//     * @throws ParseException
//     */
//    public static Date convertToDateFormat(String date) throws ParseException {
//        return DateFormatUtils.ISO_DATE_FORMAT.parse(date);
//    }
//
//    /**
//     * 解析时间到年，月，日的triple，left:year 年,middle:month 月,right:day of month 日
//     *
//     * @param date
//     * @return triple object, left:year 年,middle:month 月,right:day of month 日
//     */
//    public static Triple convertDate(String date) {
//        if (date == null) {
//            return new Triple() {
//                @Override
//                public Object getLeft() {
//                    return "";
//                }
//
//                @Override
//                public Object getMiddle() {
//                    return "";
//                }
//
//                @Override
//                public Object getRight() {
//                    return "";
//                }
//
//                @Override
//                public int compareTo(Object o) {
//                    return 0;
//                }
//            };
//        }
//
//        date = date.replace("年", "-").replace("月", "-").replace("日", "-");
//        if (date.endsWith("-")) {
//            date = date.substring(0, date.length() - 1);
//        }
//        DateTime dt;
//        try {
//            dt = DateTime.parse(date);
//        } catch (Exception e) {
////            dt = DateTime.parse(date, ISODateTimeFormat.dateHourMinuteSecondMillis());
//            dt = DateTime.parse(date, org.joda.time.format.DateTimeFormatter.("yyyy-MM-dd HH:mm:ss.s"));
//        }
//        Triple<String, String, String> t = new ImmutableTriple<>(String.valueOf(dt.getYear()),
//                String.valueOf(dt.getMonthOfYear()), String.valueOf(dt.getDayOfMonth()));
//        return t;
//    }
//
//    public static int getYear(String date) {
//        return DateTime.parse(date).year().get();
//    }
//
//    public static int getMonth(String date) {
//        return DateTime.parse(date).monthOfYear().get();
//    }
//
//    public static int getDayOfMonth(String date) {
//        return DateTime.parse(date).dayOfMonth().get();
//    }
//
//    public static int getCurrentYear() {
//        return Calendar.getInstance().get(Calendar.YEAR);
//    }
//
//    public static int getLatestPaidMonth(Calendar calendar) {
//
//        int date = calendar.get(Calendar.DATE);
//        if (date > 10) {
//            return calendar.get(Calendar.MONTH) + 1;
//        } else {
//            return calendar.get(Calendar.MONTH);
//        }
//    }
//
//    public static int getLatestPaidMonth() {
//        return getLatestPaidMonth(Calendar.getInstance());
//    }
//
//
//    public static String minusMonthsFromNow(int intervalMonths){
//
//        LocalDate date = LocalDate.now();
//        date = date.minus(intervalMonths, ChronoUnit.MONTHS);
//        return DateTimeFormatter.ISO_LOCAL_DATE.format(date);
//    }
//
//    public static String minusMonthsCountingBy30Days(int intervalMonths){
//
//        LocalDate date = LocalDate.now();
//        date = date.minus(intervalMonths*30, ChronoUnit.DAYS);
//        return DateTimeFormatter.ISO_LOCAL_DATE.format(date);
//    }
//}