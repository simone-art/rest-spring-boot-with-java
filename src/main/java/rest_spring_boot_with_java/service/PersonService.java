package rest_spring_boot_with_java.service;


import org.springframework.stereotype.Service;
import rest_spring_boot_with_java.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        List<Person> personList = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            personList.add(person);

        }
        return personList;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Fistname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Uberlandia - Minas Gerais, Brazil" + i);
        person.setGender("Male");
        return person;
    }

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
