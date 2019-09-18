package com.nestor.gonzalo.cardenas.rojas.microservices.family.controllers;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import com.nestor.gonzalo.cardenas.rojas.microservices.family.services.FamilyServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/family")
public class FamilyController {
    @Autowired
    private FamilyServiceImplement familyServiceImplement;

    //Family Maintenance
    @PostMapping
    public Mono<ResponseEntity<Family>> CreateFamily(@RequestBody Family family) {
        return familyServiceImplement.save(family).map(f -> ResponseEntity
                .created(URI.create("/api/family/".concat(f.getId())))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(f)
        );
    }

    @GetMapping
    private Mono<ResponseEntity<Flux<Family>>> FamilyList() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(familyServiceImplement.findAll())
        );
    }

    @GetMapping("{/id}")
    public Mono<ResponseEntity<Family>> SearchFamily(@PathVariable String id) {
        return familyServiceImplement.findById(id).map(f -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Family>> EditFamily(@RequestBody Family family, @PathVariable String id) {
        return familyServiceImplement.findById(id).flatMap(f -> {
            f.setFullName(family.getFullName());
            f.setGender(family.getGender());
            f.setBirthdate(family.getBirthdate());
            f.setTypeDocument(family.getTypeDocument());
            f.setNumberDocument(family.getNumberDocument());
            return familyServiceImplement.save(f);
        }).map(f -> ResponseEntity.created(URI.create("/api/family/".concat(f.getId())))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> RemoveFamily(@PathVariable String id) {
        return familyServiceImplement.findById(id).flatMap(f -> {
            return familyServiceImplement.delete(f).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    //Business Methods


}
