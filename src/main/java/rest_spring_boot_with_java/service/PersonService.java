package rest_spring_boot_with_java.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_spring_boot_with_java.model.Person;
import rest_spring_boot_with_java.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> findAll(){
        return personRepository.findAll();
    }


    public Person findById (Long id){
        logger.info("Finding one person!");
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    public Person create(Person person){
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public Person update(Long id, Person person){
        logger.info("Update one person!");
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + person.getId()));

        entity.setId(id);
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        personRepository.delete(entity);
    }
}
