package com.rsl.springreactivewebwebflux.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;

    public WeatherService() {
        this.webClient = WebClient.create("https://api.openweathermap.org/data/2.5");
    }

    public Mono<String> getCurrentWeather(String city) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", city)
                        .queryParam("appid", "your_api_key")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}