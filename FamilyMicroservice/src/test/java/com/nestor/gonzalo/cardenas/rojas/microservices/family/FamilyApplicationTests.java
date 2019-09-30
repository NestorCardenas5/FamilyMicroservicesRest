package com.nestor.gonzalo.cardenas.rojas.microservices.family;

import com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents.Family;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.util.List;

@AutoConfigureWebTestClient
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class FamilyApplicationTests {

    @Autowired
    private WebTestClient client;

    /*Family family = new Family();*/

    /*@Test
    public void FindAll() {
        family.setFullName("Nestor");
        family.setGender("Masculino");
        family.setBirthdate("1998-09-05");
        family.setTypeDocument("DNI");
        family.setNumberDocument("75469132");
        when(familyService.findAll()).thenReturn(Flux.just(family));
        Flux<Family> ObjF = familyService.findAll();
        assertResults(ObjF, family);
    }
    /*@Test
    public void listarTest() {

        client.get()
                .uri("/api/family/")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(Family.class)
                .consumeWith(response -> {
                    List<Family> family = response.getResponseBody();
                    family.forEach(p -> {
                        System.out.println(p.getFullName());
                    });

                    Assertions.assertThat(family.size()>0).isTrue();
                });
        //.hasSize(9);
    }*/
}
