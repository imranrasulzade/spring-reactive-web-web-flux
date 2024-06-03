package com.rsl.springreactivewebwebflux.repositories;

import com.rsl.springreactivewebwebflux.documents.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    Mono<Person> findByFirstName(String firstName);
}