package br.com.ana.controllers;

import br.com.ana.controllers.docs.PersonControllerDocs;
import br.com.ana.data.dto.PersonDTO;
import br.com.ana.services.PersonServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/person")      // localhost:8080/person
@Tag(name = "People", description = "Endpoints for managing People")
public class PersonController implements PersonControllerDocs {

    @Autowired
    private PersonServices service;


    // Retorna por ID   localhost:8080/person/1

    @GetMapping(
            value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    "application/x-yaml"

            }
    )

    @Override
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }


    // Retorna todos   localhost:8080/person

    @GetMapping(
            value = "",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    "application/x-yaml"
            }
    )

    @Override
    public ResponseEntity<Page<PersonDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    )
    {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.findAll(pageable));
    }


    // Cria usuário   localhost:8080/PersonDTO

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"
            },
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"
            }
    )

    @Override
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }


    // Atualiza e Altera um usuário    localhost:8080/PersonDTO


    @PutMapping(
            consumes = {"application/json", "application/xml", "application/x-yaml"},
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )

    @Override
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return service.update(personDTO);
    }


    // Deleta um usuário por ID   localhost:8080/person/1

    @DeleteMapping(
            value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    "application/x-yaml"

            }
    )

    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}















