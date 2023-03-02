package com.timeseries.controller;
import com.timeseries.core.TimeSeriesPoint;
import com.timeseries.ingestion.TimeSeriesIngester;
import com.timeseries.query.TimeSeriesQuery;
import com.timeseries.service.AnalyticsService;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1/timeseries")
@RequiredArgsConstructor
public class TimeSeriesController {
    private final TimeSeriesIngester ingester;
    private final AnalyticsService analyticsService;
    @PostMapping
    public ResponseEntity<Void> ingest(@RequestBody List<TimeSeriesPoint> points) {
        ingester.ingest(points);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/analytics/{metric}")
    public ResponseEntity<Map<String, Object>> getAnalytics(@PathVariable String metric,
                                                             @RequestParam long startTime,
                                                             @RequestParam long endTime) {
        return ResponseEntity.ok(analyticsService.getAnalytics(metric, startTime, endTime));
    }
}
