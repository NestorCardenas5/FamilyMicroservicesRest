package com.nestor.gonzalo.cardenas.rojas.microservices.family.services;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.dao.FamilyDao;
import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import com.nestor.gonzalo.cardenas.rojas.microservices.family.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FamilyServiceImplement implements FamilyRepository {
    @Autowired
    private FamilyDao dao;

    //Family Maintenance
    @Override
    public Flux<Family> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<Family> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Mono<Family> save(Family family) {
        return dao.save(family);
    }

    @Override
    public Mono<Void> delete(Family family) {
        return dao.delete(family);
    }
    //Bussines Methods
    @Override
    public Mono<Family> findByFullName(String fullName) {
        return dao.findByFullName(fullName);
    }

    @Override
    public Mono<Family> findByNumberDocument(String numberDocument) {
        return dao.findByNumberDocument(numberDocument);
    }
}
