package rest_spring_boot_with_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_spring_boot_with_java.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
