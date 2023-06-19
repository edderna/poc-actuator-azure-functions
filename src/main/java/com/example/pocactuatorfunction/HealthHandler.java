package com.example.pocactuatorfunction;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class HealthHandler extends FunctionInvoker<String, HealthComponent> {
    @FunctionName("healthcheck")
    public HealthComponent healthcheck(@HttpTrigger(name = "req", route = "healthcheck",
            authLevel = AuthorizationLevel.ANONYMOUS,
            methods = HttpMethod.GET) final HttpRequestMessage<Optional<String>> request, ExecutionContext context) {
        context.getLogger().info("Function App instance is up");
        return this.handleRequest(context);
    }
}
