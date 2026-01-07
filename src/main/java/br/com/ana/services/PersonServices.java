package br.com.ana.services;

import br.com.ana.data.dto.PersonDTO;
import br.com.ana.exception.ResourceNotFoundException;

import static br.com.ana.mapper.ObjectMapper.parseObject;

import br.com.ana.mapper.ObjectMapper;
import br.com.ana.model.Person;
import br.com.ana.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository repository;


    public Page<PersonDTO> findAll(Pageable pageable) {

        logger.info("Finding all People!");

        return repository.findAll(pageable)
                .map(person -> parseObject(person, PersonDTO.class));
    }




    public PersonDTO findById(Long id) {

        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        var dto = ObjectMapper.parseObject(entity, PersonDTO.class);

        return dto;
    }




    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one Person!");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }


    public PersonDTO update(PersonDTO person) {

        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setBirthDay(person.getBirthDay());


        return parseObject(repository.save(entity), PersonDTO.class);

    }


    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);

    }


    }










