package com.example.pocactuatorfunction;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class TestHandler extends FunctionInvoker<String, String> {

  @FunctionName("test")
  public HttpResponseMessage execute(@HttpTrigger(name = "req",
      methods = {HttpMethod.PUT},
      authLevel = AuthorizationLevel.ANONYMOUS,
      route = "v1/test") final HttpRequestMessage<Optional<String>> request,
      final ExecutionContext context) {

    return request.createResponseBuilder(HttpStatus.OK).build();
  }
}
