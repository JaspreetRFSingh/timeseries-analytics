package com.timeseries.service;
import com.timeseries.aggregation.AggregationFunction;
import com.timeseries.query.QueryEngine;
import com.timeseries.query.TimeSeriesQuery;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Service
@RequiredArgsConstructor
@Slf4j
public class AnalyticsService {
    private final QueryEngine queryEngine;
    public Map<String, Object> getAnalytics(String metric, long startTime, long endTime) {
        Map<String, Object> result = new HashMap<>();
        TimeSeriesQuery query = TimeSeriesQuery.builder()
                .metric(metric).startTime(startTime).endTime(endTime).build();
        result.put("avg", queryEngine.executeAggregation(query, AggregationFunction.AVG));
        result.put("min", queryEngine.executeAggregation(query, AggregationFunction.MIN));
        result.put("max", queryEngine.executeAggregation(query, AggregationFunction.MAX));
        result.put("count", queryEngine.executeAggregation(query, AggregationFunction.COUNT));
        return result;
    }
}
