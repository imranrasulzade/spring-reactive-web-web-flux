//package com.rsl.springreactivewebwebflux.handlers;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.HandlerStrategies;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebExceptionHandler;
//import reactor.core.publisher.Mono;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@Order(-2)
//public class GlobalErrorHandler implements WebExceptionHandler {
//
//    @Override
//    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
//        Map<String, Object> errorDetails = new HashMap<>();
//        errorDetails.put("message", ex.getMessage());
//        errorDetails.put("timestamp", System.currentTimeMillis());
//
//        return RouterFunctions.toHttpHandler(
//                        RouterFunctions.route()
//                                .build(),
//                        HandlerStrategies.builder().exceptionHandler((serverRequest, throwable) ->
//                                ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                                        .contentType(MediaType.APPLICATION_JSON)
//                                        .body(BodyInserters.fromValue(errorDetails))
//                                        .build())
//                                        .handle(exchange);
//    }
//}