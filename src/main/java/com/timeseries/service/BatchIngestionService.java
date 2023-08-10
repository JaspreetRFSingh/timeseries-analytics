package com.timeseries.service;
import com.timeseries.core.TimeSeriesPoint;
import com.timeseries.storage.TimeSeriesStorage;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Service
@RequiredArgsConstructor
@Slf4j
public class BatchIngestionService {
    private final TimeSeriesStorage storage;
    public void ingestBatch(List<List<TimeSeriesPoint>> batches) {
        log.info("Processing {} batches", batches.size());
        batches.forEach(storage::store);
    }
}
