package com.timeseries.util;
import java.time.*;
public class TimestampUtil {
    public static long now() { return System.currentTimeMillis(); }
    public static long hoursAgo(int hours) { return Instant.now().minus(Duration.ofHours(hours)).toEpochMilli(); }
}
