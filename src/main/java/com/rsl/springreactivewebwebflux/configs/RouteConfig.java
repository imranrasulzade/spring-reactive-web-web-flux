package com.rsl.springreactivewebwebflux.configs;

import com.rsl.springreactivewebwebflux.handlers.PersonHandler;
import com.rsl.springreactivewebwebflux.handlers.TimeHandler;
import com.rsl.springreactivewebwebflux.handlers.WeatherHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class RouteConfig {

    private final PersonHandler personHandler;
    private final TimeHandler timeHandler;
    private final WeatherHandler weatherHandler;

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route()
                .GET("/hello", request -> ServerResponse.ok().bodyValue("Hello, WebFlux!"))
                .GET("/person", personHandler::getPerson)
//                .GET("/time", timeHandler::streamTime)
                .GET("/weather", weatherHandler::getCurrentWeather)

                .build();
    }
}