package com.rsl.springreactivewebwebflux.handlers;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class TimeHandler {

//    public Flux<ServerResponse> streamTime(ServerRequest request) {
//        return Flux.interval(Duration.ofSeconds(1))
//                .map(tick -> ServerResponse.ok()
//                        .contentType(MediaType.TEXT_EVENT_STREAM)
//                        .bodyValue("Current time: " + LocalDateTime.now()))
//                .onErrorResume(e -> ServerResponse.status(500).build());
//    }


}

/***
 * https://medium.com/@bubu.tripathy/spring-webflux-101-d8a75089b2fd#:~:text=Spring%20WebFlux%20is%20a%20reactive%20web%20framework%20that%20is%20part,advantage%20of%20reactive%20programming%20principles.
 ***/