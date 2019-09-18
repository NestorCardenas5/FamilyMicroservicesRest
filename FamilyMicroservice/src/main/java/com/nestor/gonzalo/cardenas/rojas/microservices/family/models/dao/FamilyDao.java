package com.nestor.gonzalo.cardenas.rojas.microservices.family.models.dao;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface FamilyDao extends ReactiveMongoRepository<Family,String> {

    Mono<Family> findByFullName(String fullName);

    Mono<Family> findByNumberDocument(String numberDocument);
}
