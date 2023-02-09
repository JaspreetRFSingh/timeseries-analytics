package com.timeseries.query;
import lombok.*;
import java.util.*;
@Data
@Builder
public class TimeSeriesQuery {
    private String metric;
    private long startTime;
    private long endTime;
    private String aggregation;
    private long windowMs;
    private Map<String, String> filters;
}
