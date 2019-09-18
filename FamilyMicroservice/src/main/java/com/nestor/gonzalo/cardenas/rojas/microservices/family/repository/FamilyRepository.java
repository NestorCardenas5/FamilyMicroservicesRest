package com.nestor.gonzalo.cardenas.rojas.microservices.family.repository;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyRepository {
    //Family Maintenance

    Flux<Family> findAll();

    Mono<Family> findById(String id);

    Mono<Family> save(Family family);

    Mono<Void> delete(Family family);

    //Business Methods

    Mono<Family> findByFullName(String fullName);

    Mono<Family> findByNumberDocument(String numberDocument);
}
