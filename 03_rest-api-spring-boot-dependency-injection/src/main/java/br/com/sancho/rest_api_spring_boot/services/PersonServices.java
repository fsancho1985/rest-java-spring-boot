package br.com.sancho.rest_api_spring_boot.services;

import br.com.sancho.rest_api_spring_boot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Person> findAll(){

        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male");
        return person;
    }


}
