package com.timeseries.core;
import lombok.*;
import java.time.*;
import java.util.*;
@Data
@Builder
public class TimeSeriesPoint {
    private String metric;
    private double value;
    private long timestamp;
    private Map<String, String> tags;
    public Instant getInstant() { return Instant.ofEpochMilli(timestamp); }
}
