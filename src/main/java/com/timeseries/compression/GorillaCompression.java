package com.timeseries.compression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Component
@Slf4j
public class GorillaCompression {
    public byte[] compress(double[] values) {
        log.info("Compressing {} values using Gorilla algorithm", values.length);
        return new byte[0];
    }
    public double[] decompress(byte[] data) {
        return new double[0];
    }
}
