package com.poconeone.controller;

import com.poconeone.entity.Person;
import com.poconeone.entity.Title;
import com.poconeone.repository.PersonRepository;
import com.poconeone.repository.TitleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.ExportException;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@RestController
@RequestMapping("/person")
public class PersonController {

    public PersonController(PersonRepository personRepository, TitleRepository titleRepository) {
        this.personRepository = personRepository;
        this.titleRepository = titleRepository;
    }

    private final PersonRepository personRepository;

    private final TitleRepository titleRepository;

    @PostMapping("/new")
    public ResponseEntity<String> newPerson() {
        var firstTitle = titleRepository.getReferenceById(1L);
        try {
            if (isNotEmpty(firstTitle.getId())) {
                savePerson(firstTitle, "Conrado");
            } else {
                saveNewPerson();
            }
        } catch (EntityNotFoundException e) {
            saveNewPerson();
        }
        return ResponseEntity.ok("OK.");
    }

    private void saveNewPerson() {
        savePerson(Title.builder()
                .name("Developer")
                .build(), "Erica");
    }

    private void savePerson(Title firstTitle, String name) {
        personRepository.save(Person.builder()
                .name(name)
                .title(firstTitle)
                .build());
    }

}
