package br.com.sancho.rest_api_spring_boot.services;

import br.com.sancho.rest_api_spring_boot.exceptions.ResourceNotFoundException;
import br.com.sancho.rest_api_spring_boot.model.Person;
import br.com.sancho.rest_api_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id) {

        logger.info("Finding person by id!");

         return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
    }

    public List<Person> findAll(){

        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person create(Person person) {

        logger.info("Creating person!");

        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {

        logger.info("Deleting person!");

        Person entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        repository.delete(entity);
    }

}
