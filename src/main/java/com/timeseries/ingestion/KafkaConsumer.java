package com.timeseries.ingestion;
import com.timeseries.core.TimeSeriesPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;
@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "timeseries", groupId = "timeseries-consumer")
    public void consume(String message) {
        log.info("Received time series data from Kafka");
    }
}
