package com.rsl.springreactivewebwebflux.handlers;

import com.rsl.springreactivewebwebflux.services.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WeatherHandler {

    private final WeatherService weatherService;

    public WeatherHandler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Mono<ServerResponse> getCurrentWeather(ServerRequest request) {
        String city = request.queryParam("city").orElse("London");
        Mono<String> weatherData = weatherService.getCurrentWeather(city);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(weatherData, String.class);
    }
}