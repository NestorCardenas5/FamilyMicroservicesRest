package com.nestor.gonzalo.cardenas.rojas.microservices.family.controllers;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.dao.FamilyDao;
import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings({"checkstyle:LineLength", "checkstyle:Indentation"})
@RestController
@RequestMapping("/api/family")
public class FamilyController {

    @Autowired
    private FamilyDao dao;

    //Family Maintenance
    @SuppressWarnings({"checkstyle:MissingJavadocMethod", "checkstyle:Indentation"})
    @PostMapping public Mono<ResponseEntity<Family>> createFamily(@RequestBody Family family) {
        return dao.save(family).map(f -> ResponseEntity
                .created(URI.create("/api/family/".concat(f.getId())))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(f)
        );}
    @SuppressWarnings({"checkstyle:Indentation", "checkstyle:MissingJavadocMethod"})
    @GetMapping public Mono<ResponseEntity<Flux<Family>>> familyList() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(dao.findAll())
        );
    }
    @SuppressWarnings({"checkstyle:Indentation", "checkstyle:MethodName", "checkstyle:MissingJavadocMethod"})
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Family>> SearchFamily(@PathVariable String id) {
        return dao.findById(id).map(f -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @SuppressWarnings({"checkstyle:Indentation", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Family>> editFamily(@RequestBody Family family, @PathVariable String id) {
        return dao.findById(id).flatMap(f -> {
            f.setFullName(family.getFullName());
            f.setGender(family.getGender());
            f.setBirthdate(family.getBirthdate());
            f.setTypeDocument(family.getTypeDocument());
            f.setNumberDocument(family.getNumberDocument());
            return dao.save(f);
        }).map(f -> ResponseEntity.created(URI.create("/api/family/".concat(f.getId())))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @SuppressWarnings({"checkstyle:Indentation", "checkstyle:MissingJavadocMethod"})
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> removeFamily(@PathVariable String id) {
        return dao.findById(id).flatMap(f -> {
            return dao.delete(f).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    //Business Methods
    @SuppressWarnings({"checkstyle:Indentation", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod", "checkstyle:LineLength"})
    @GetMapping("/numberDocument/{number}")
    public Mono<ResponseEntity<Family>> findByNumberDocument(@PathVariable String number){
        return dao.findByNumberDocument(number).map(f-> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    /*@GetMapping
    public Mono<ResponseEntity<Flux<Family>>> findFamilybetweenbirthdates(@PathVariable Date date1, @PathVariable Date date2) {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(familyServiceImplement.findFamilybetweenbirthdates(date1,date2))
        ).defaultIfEmpty(ResponseEntity.notFound().build());
    }*/
}
