package br.com.sancho.rest_api_spring_boot.repositories;

import br.com.sancho.rest_api_spring_boot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
