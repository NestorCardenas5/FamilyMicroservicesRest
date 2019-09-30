package com.nestor.gonzalo.cardenas.rojas.microservices.family.services;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.dao.FamilyDao;
import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import com.nestor.gonzalo.cardenas.rojas.microservices.family.repository.FamilyRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings("checkstyle:Indentation")
@Service
public class FamilyServiceImplement implements FamilyRepository {

    @Autowired

    private FamilyRepository familyrepository;

    @Autowired

    private FamilyDao dao;

    //Family Maintenance

    @SuppressWarnings("checkstyle:Indentation")
    @Override
    public Flux<Family> findAll() {
        return dao.findAll();
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Override
    public Mono<Family> findById(String id) {
        return familyrepository.findById(id);
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Override
    public Mono<Family> save(Family family) {
        return familyrepository.save(family);
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Override
    public Mono<Void> delete(Family family) {
        return familyrepository.delete(family);
    }

    //Bussines Methods
    @SuppressWarnings("checkstyle:Indentation")
    @Override
    public Mono<Family> findByFullName(String fullName) {
        return familyrepository.findByFullName(fullName);
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Override
    public Mono<Family> findByNumberDocument(String numberDocument) {
        return familyrepository.findByNumberDocument(numberDocument);
    }

    @SuppressWarnings("checkstyle:Indentation")
    @Override
    public Flux<Family> findFamilybetweenbirthdates(Date date1, Date date2) {
        return familyrepository.findFamilybetweenbirthdates(date1, date2);
    }

}
