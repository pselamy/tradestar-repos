package com.verlumen.tradestar.repositories.candles.alphavantage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

class TimeFormatter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            // expected format: "2022-05-06 20:00:00"
            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");


    Instant format(String time, TimeZone timeZone) {
        LocalDateTime ldt = LocalDateTime.parse(time, DATE_TIME_FORMATTER);
        ZoneId zoneId = timeZone.toZoneId();
        ZonedDateTime zdt = ZonedDateTime.of(ldt, zoneId);
        return zdt.toInstant();
    }
}
