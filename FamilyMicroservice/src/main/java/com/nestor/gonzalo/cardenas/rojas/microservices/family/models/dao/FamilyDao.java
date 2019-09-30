package com.nestor.gonzalo.cardenas.rojas.microservices.family.models.dao;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

@SuppressWarnings("checkstyle:Indentation")
public interface FamilyDao extends ReactiveMongoRepository<Family,String> {

    public Mono<Family> findByFullName(String fullName);

    public Mono<Family> findByNumberDocument(String numberDocument);

    //public Flux<Family> findFamilybetweenbirthdates(Date date1,Date date2);
}
