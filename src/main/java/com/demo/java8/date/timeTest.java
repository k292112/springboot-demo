package com.demo.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），
 * 过程（during）与时钟（clock）的操作。
 */

public class timeTest {
    public static void main(String[] args) {
        LocalDateTimeTest();
    }

    public static void LocalDateTimeTest() {
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);// 2020-09-29T17:34:04.833
        System.out.print(currentTime.getYear() + "\t");
        System.out.print(currentTime.getMonth() + "\t");
        System.out.print(currentTime.getDayOfMonth() + "\t");
        System.out.print(currentTime.getHour() + "\t");
        System.out.print(currentTime.getMinute() + "\t");
        System.out.println(currentTime.getSecond() + "\t");
        // 指定日期
        LocalDateTime date2 = currentTime.withDayOfMonth(3).withYear(2012); //2012-09-03T17:34:04.833
        System.out.println(date2);

        // 日期 格式化  线程安全
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化为String
        String format = currentTime.format(dateTimeFormatter);
        System.out.println(format);// 2020-09-29 17:45:04
        // 格式化为 localDateTime
        LocalDateTime date1 = LocalDateTime.parse(format,dateTimeFormatter);
        System.out.println(date1);

    }
    public void testAPI(){
        //获取当前日期
        LocalDate.now();
        //获取当前时间
        LocalTime.now();
        //获取当前日期+时间
        LocalDateTime.now();
        //构造日期
        LocalDate.of(2020,06,05);
        //构造日期
        LocalDate.parse("2020-06-05");
        //本月第一天
        LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        //本月 第n天
        LocalDate.now().withDayOfMonth(2);
        //本月最后一天
        LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        //计算已过去的日期
        LocalDate.now().minusDays(1);//昨天
        LocalDate.now().minusWeeks(1);//上周
        LocalDate.now().minusMonths(1);//上个月
        LocalDate.now().minusYears(1);//上一年

        //计算将来的日期（加法）
        LocalDate.now().plusDays(1);//明天
        LocalDate.now().plusWeeks(1);//下周
        LocalDate.now().plusMonths(1);//下个月的今天
        LocalDate.now().plusYears(1);//明年

        //计算相差天数，切记不要使用Period.between()[因为跨月的话天数会重置，还要自己去计算月份，甚至年份]   要用 ChronoUnit.DAYS.between
        LocalDate date = LocalDate.of(2020,06,05);
        //当天日期
        LocalDate nowDate = LocalDate.now();
        //计算2020-06-05 距离今天相差多少天
        ChronoUnit.DAYS.between(date, nowDate);

    }
}
