package com.example.pocactuatorfunction;

import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class Healthcheck implements Supplier<HealthComponent> {

    private final HealthEndpoint healthEndpoint;

    public Healthcheck(HealthEndpoint healthEndpoint) {
        this.healthEndpoint = healthEndpoint;
    }

    @Override
    public HealthComponent get() {
        return healthEndpoint.health();
    }
}
