package com.timeseries.aggregation;
import com.timeseries.core.TimeSeriesPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Component
@Slf4j
public class Aggregator {
    public double aggregate(List<TimeSeriesPoint> points, AggregationFunction function) {
        if (points.isEmpty()) return 0;
        return switch (function) {
            case AVG -> points.stream().mapToDouble(TimeSeriesPoint::getValue).average().orElse(0);
            case SUM -> points.stream().mapToDouble(TimeSeriesPoint::getValue).sum();
            case MIN -> points.stream().mapToDouble(TimeSeriesPoint::getValue).min().orElse(0);
            case MAX -> points.stream().mapToDouble(TimeSeriesPoint::getValue).max().orElse(0);
            case COUNT -> points.size();
            default -> 0;
        };
    }
    public Map<String, Double> downsample(List<TimeSeriesPoint> points, long windowMs, AggregationFunction function) {
        Map<String, Double> result = new LinkedHashMap<>();
        log.info("Downsampling {} points with window {}ms", points.size(), windowMs);
        return result;
    }
}
