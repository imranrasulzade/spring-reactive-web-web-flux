# Changes

## 1. Dependencies
Add to build.gradle

```groovy

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'org.springframework.boot:spring-boot-starter-data-mongodb-reactive'
}

```

## 2. Route Config
Add to java config class
```java
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
//              other routes. etc...
                .build();
    }
}
```
