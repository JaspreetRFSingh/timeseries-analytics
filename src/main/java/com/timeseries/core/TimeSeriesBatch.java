package com.timeseries.core;
import lombok.*;
import java.util.*;
@Data
@Builder
public class TimeSeriesBatch {
    private List<TimeSeriesPoint> points;
    private String source;
    private long ingestTime;
}
