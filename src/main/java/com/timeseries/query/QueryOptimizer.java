package com.timeseries.query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Component
@Slf4j
public class QueryOptimizer {
    public TimeSeriesQuery optimize(TimeSeriesQuery query) {
        log.info("Optimizing query for metric: {}", query.getMetric());
        return query;
    }
}
