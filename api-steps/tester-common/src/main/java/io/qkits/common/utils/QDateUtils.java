package io.qkits.common.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author patrick created on 2019-05-05
 **/
public class QDateUtils extends DateUtil {
    private QDateUtils() {
    }

    /**
     * 解析时间到年，月，日的triple，left:year 年,middle:month 月,right:day of month 日
     *
     * @param date
     * @return
     */
    public static Triple asTriple(Date date) {
        Triple<Integer, Integer, Integer> ymd = new Triple<>();
        ymd.setLeft(DateUtil.year(date));
        ymd.setMiddle(DateUtil.month(date)+1);
        ymd.setRight(DateUtil.dayOfMonth(date));
        return ymd;
    }

    public static Triple asTriple(long mSeconds) {
        return asTriple(new Date(mSeconds));
    }

    public static Triple asTriple(String dateStr) {
        return asTriple(DateUtil.parseDate(dateStr));
    }

    public static int minusMonthsFromNow(int intervalMonth){
        return DateUtil.offsetMonth(new Date(),-intervalMonth).month()+1;
    }
}
