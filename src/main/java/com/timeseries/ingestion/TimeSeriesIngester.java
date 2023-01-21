package com.timeseries.ingestion;
import com.timeseries.core.TimeSeriesPoint;
import com.timeseries.storage.TimeSeriesStorage;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Component
@RequiredArgsConstructor
@Slf4j
public class TimeSeriesIngester {
    private final TimeSeriesStorage storage;
    public void ingest(List<TimeSeriesPoint> points) {
        log.info("Ingesting {} time series points", points.size());
        storage.store(points);
    }
    public void ingestSingle(TimeSeriesPoint point) {
        storage.store(Collections.singletonList(point));
        log.info("Ingested metric: {} value: {}", point.getMetric(), point.getValue());
    }
}
