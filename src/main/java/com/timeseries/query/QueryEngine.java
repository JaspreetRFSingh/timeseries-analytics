package com.timeseries.query;
import com.timeseries.aggregation.AggregationFunction;
import com.timeseries.aggregation.Aggregator;
import com.timeseries.core.TimeSeriesPoint;
import com.timeseries.storage.TimeSeriesStorage;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Component
@RequiredArgsConstructor
@Slf4j
public class QueryEngine {
    private final TimeSeriesStorage storage;
    private final Aggregator aggregator;
    public List<TimeSeriesPoint> executeQuery(TimeSeriesQuery query) {
        log.info("Executing query for metric: {}", query.getMetric());
        return storage.query(query.getMetric(), query.getStartTime(), query.getEndTime());
    }
    public double executeAggregation(TimeSeriesQuery query, AggregationFunction function) {
        List<TimeSeriesPoint> points = executeQuery(query);
        return aggregator.aggregate(points, function);
    }
}
