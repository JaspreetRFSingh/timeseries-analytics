package com.timeseries.storage;
import com.timeseries.core.TimeSeriesPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class TimeSeriesStorage {
    private final ConcurrentHashMap<String, List<TimeSeriesPoint>> data = new ConcurrentHashMap<>();
    public void store(List<TimeSeriesPoint> points) {
        points.forEach(p -> {
            data.computeIfAbsent(p.getMetric(), k -> new ArrayList<>()).add(p);
        });
    }
    public List<TimeSeriesPoint> query(String metric, long startTime, long endTime) {
        return data.getOrDefault(metric, Collections.emptyList()).stream()
                .filter(p -> p.getTimestamp() >= startTime && p.getTimestamp() <= endTime)
                .toList();
    }
}
