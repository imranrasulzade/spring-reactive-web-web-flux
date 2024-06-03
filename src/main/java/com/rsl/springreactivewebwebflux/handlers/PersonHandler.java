package com.rsl.springreactivewebwebflux.handlers;

import com.rsl.springreactivewebwebflux.documents.Person;
import com.rsl.springreactivewebwebflux.repositories.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {

    private final PersonRepository personRepository;

    public PersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        String firstName = request.queryParam("firstName").orElse(null);
        Mono<Person> personMono = personRepository.findByFirstName(firstName);
        return personMono
            .flatMap(person -> ServerResponse.ok().bodyValue(person))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
}