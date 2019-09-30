package com.nestor.gonzalo.cardenas.rojas.microservices.family.repository;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@SuppressWarnings({"checkstyle:EmptyLineSeparator", "checkstyle:Indentation"})
public interface FamilyRepository {
    //Family Maintenance

    public Flux<Family> findAll();

    public Mono<Family> findById(String id);

    public Mono<Family> save(Family family);

    public Mono<Void> delete(Family family);

    //Business Methods

    public Mono<Family> findByFullName(String fullName);

    public Mono<Family> findByNumberDocument(String numberDocument);
    @SuppressWarnings("checkstyle:GenericWhitespace")
    public Flux<Family>findFamilybetweenbirthdates(Date date1, Date date2);
}
