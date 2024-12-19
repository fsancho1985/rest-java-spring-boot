package br.com.sancho.rest_api_spring_boot.services;

import br.com.sancho.rest_api_spring_boot.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {

        logger.info("Finding person by id!");
         Person person = new Person();
         person.setId(counter.incrementAndGet());
         person.setFirstName("Francisco");
         person.setLastName("Sancho");
         person.setAddress("Marília - São Paulo - Brasil");
         person.setGender("Male");
         return person;
    }
}
