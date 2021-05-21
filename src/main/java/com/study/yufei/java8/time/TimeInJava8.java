package com.study.yufei.java8.time;

import javax.xml.crypto.Data;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;

/**
 * java8 时间处理
 *
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

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("+00:00"));
        Instant instantNow = Instant.now();
        System.out.println("instant格式化2：" + dateTimeFormatter2.format(instantNow));


        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("+00:00")).withMinute(0).withSecond(0);
        Instant hourInstant = localDateTime2.toInstant(ZoneOffset.of("+00:00"));
        Date hourDate = Date.from(hourInstant);
        System.out.println();

        Instant plus90 = Instant.now().plus(1, ChronoUnit.DAYS).atOffset(ZoneOffset.of("+00:00")).toInstant();
        System.out.println(plus90);


        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime localDateTime3 = now1.minusDays(now1.getDayOfWeek().getValue());

        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.of("+00:00"));
        LocalDateTime with = localDateTime4.with(DayOfWeek.MONDAY);
        LocalDateTime with2 = localDateTime4.withHour(0).withMinute(0).withSecond(0).withNano(0).with(DayOfWeek.MONDAY);


        String dateTimeStr = "2021-03-09" + " " + "00:00:00";
        LocalDateTime localDateTime5 = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Instant instant = localDateTime5.toInstant(ZoneOffset.of("+00:00"));
        Date from = Date.from(instant);
        System.out.println();

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate nextMonthOfFirstDay = firstDayOfMonth.plus(1, ChronoUnit.MONTHS);
        System.out.println();

        Instant parse = Instant.parse("2021-04-16T09:00:00.00Z");
        long time = Date.from(parse).getTime();
        long currentTimeMillis = System.currentTimeMillis();
        long epochSecond = parse.getEpochSecond();
        System.out.println();

        OffsetDateTime now2 = OffsetDateTime.now(ZoneOffset.UTC);
        LocalDate localDate = now2.toLocalDate();
        int year = OffsetDateTime.now(ZoneOffset.UTC).getYear();
        System.out.println(localDate.toString());

        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println(utc);
        String curDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(utc);
        System.out.println(curDate);

    }
}

