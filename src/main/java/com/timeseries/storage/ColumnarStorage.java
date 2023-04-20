package com.timeseries.storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Component
@Slf4j
public class ColumnarStorage {
    public void storeColumn(String metric, double[] values) {
        log.info("Storing column data for metric: {}", metric);
    }
}
