package com.timeseries.aggregation;
import com.timeseries.core.TimeSeriesPoint;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class AggregatorTest {
    @Test void testAverage() {
        Aggregator agg = new Aggregator();
        List<TimeSeriesPoint> points = Arrays.asList(
                TimeSeriesPoint.builder().value(10).build(),
                TimeSeriesPoint.builder().value(20).build()
        );
        assertEquals(15.0, agg.aggregate(points, AggregationFunction.AVG));
    }
}
