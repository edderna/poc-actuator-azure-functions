package com.example.pocactuatorfunction.custom;

import com.azure.core.util.Context;
import com.azure.storage.blob.BlobContainerClient;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class BlobStorageHealthIndicator implements HealthIndicator {
    private final BlobContainerClient blobClient;

    public BlobStorageHealthIndicator(BlobContainerClient blobClient) {
        this.blobClient = blobClient;
    }

    @Override
    public Health health() {
        try {
            boolean canConnect = blobClient.existsWithResponse(Duration.ofSeconds(10), Context.NONE).getValue();
            if (canConnect) {
                return Health.up().build();
            }
            return Health.down().build();
        } catch (Exception e) {
            return Health.down(e).build();
        }


    }
}
