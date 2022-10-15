package com.bobocode.ticketservice.generator.date;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class DateGenerator {

    public static LocalDate generate(Timestamp startDate, Timestamp endDate) {
        Objects.requireNonNull(startDate, "Start date must not be null!");
        Objects.requireNonNull(endDate, "End date must not be null!");

        var start = LocalDateTime.ofEpochSecond(startDate.getSeconds(), startDate.getNanos(), ZoneOffset.UTC).toLocalDate();
        var end = LocalDateTime.ofEpochSecond(endDate.getSeconds(), endDate.getNanos(),ZoneOffset.UTC).toLocalDate();

        long maxSize = ChronoUnit.DAYS.between(start, end) + 1;
        return Stream.iterate(start, d -> d.plusDays(1))
                .limit(maxSize)
                .skip(ThreadLocalRandom.current().nextLong(maxSize))
                .findFirst()
                .orElse(start);
    }
}