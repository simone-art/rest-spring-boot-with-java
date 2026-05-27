package rest_spring_boot_with_java.service;


import org.springframework.stereotype.Service;
import rest_spring_boot_with_java.model.Person;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById (String id){
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlandia - Minas Gerais, Brazil");
        person.setGender("Male");
        return person;
    }
}
