package com.study.yufei.java8.time;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

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

        long timeTemp = 1622447850;
        Instant instant1 = Instant.ofEpochSecond(timeTemp);

        Date date1 = new Date();
        OffsetDateTime offsetDateTime1 = Instant.ofEpochMilli(date1.getTime() + 1000).atOffset(ZoneOffset.of("+00:00"));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(offsetDateTime));

        LocalDateTime switchDateTime = LocalDateTime.of(2021, 8, 9,
                        0, 0, 0)
                .atOffset(ZoneOffset.of("+00:00")).toLocalDateTime();
        System.out.println(switchDateTime);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String normalizeMonth = StringUtils.leftPad(String.valueOf(calendar.get(Calendar.MONTH) + 1), 2, '0');
        String normalizeDay = StringUtils.leftPad(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2, '0');
        String dateStr = calendar.get(Calendar.YEAR) + "-" + normalizeMonth + "-" + normalizeDay;
        Instant startInstant = Instant.parse(dateStr + "T00:00:00.00Z");
        Instant endInstant = Instant.parse("2038-01-01T00:00:00.00Z");

        System.out.println(Date.from(startInstant) + "");
        System.out.println(Date.from(endInstant) + "");


        LocalDateTime firstday = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
        Date from1 = Date.from(firstday.atOffset(ZoneOffset.of("+00:00")).toInstant());

        LocalDateTime firstDayOfNextWeek = LocalDateTime.now().with(DayOfWeek.MONDAY).withHour(0).withMinute(0).withSecond(0).withNano(0);
        Date from2 = Date.from(firstDayOfNextWeek.atOffset(ZoneOffset.of("+00:00")).toInstant());

        System.out.printf(from1 + "");

        Instant dayTimeInstant = new Date(1639526400000L).toInstant();
        Instant nowDateInstant = LocalDateTime.now()
                .withHour(0).withMinute(0).withSecond(0).withNano(0)
                .atOffset(ZoneOffset.of("+00:00"))
                .toInstant();
        System.out.println("dayTimeInstant.compareTo(nowDateInstant): " + dayTimeInstant.compareTo(nowDateInstant));
        System.out.println("dayTimeInstant.compareTo(nowDateInstant): " + (dayTimeInstant.toEpochMilli() == nowDateInstant.toEpochMilli()));


    }
}

