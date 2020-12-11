package com.study.yufei.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;

/**
 * java8 时间处理
 * @author yufei.wang
 * @date 2020/11/20 22:17
 */
public class TimeInJava8 {

    public static void main(String[] args) {

        Instant now = Instant.now();
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(now, ZoneOffset.of("+00:00"));
        Instant plusNow = now.plus(1, ChronoUnit.DAYS);
        Date nowToDate = Date.from(now);
        Date date = new Date();
        Instant dateToNow = date.toInstant();

        // 时区时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LocalDateTime localDateTime = ZonedDateTime.now().toLocalDateTime();
        OffsetDateTime offsetDateTime = LocalDateTime.now().atOffset(ZoneOffset.of("+00:00"));
        ZonedDateTime zonedDateTime1 = LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai"));

        // 时间段
        Instant startNow = Instant.now().minus(1, ChronoUnit.DAYS);
        Duration between = Duration.between(startNow, Instant.now());


        System.out.println(now);
        System.out.println(plusNow);
        System.out.println(localDateTime1);
        System.out.println(nowToDate);
        System.out.println(date);
        System.out.println(dateToNow);

        System.out.println(zonedDateTime);
        System.out.println(localDateTime);
        System.out.println(offsetDateTime);
        System.out.println(zonedDateTime1);

        System.out.println(between.toDays());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH").withZone(ZoneId.of("+00:00"));
        Instant nextHour = Instant.now().plus(1, ChronoUnit.HOURS);
        System.out.println("instant格式化：" + dateTimeFormatter.format(nextHour));

    }
}
