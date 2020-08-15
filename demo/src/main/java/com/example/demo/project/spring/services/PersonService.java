package com.example.demo.project.spring.services;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Page<Person> findAllPeople(Pageable pageable);

    Person findPersonByPesel(String pesel);

    Optional<Person> findPersonById(Integer id);

    Iterable<Person> listAllPeople();

    List<Person> listAllPeopleByBirthplace(City city);

    Person savePerson(Person person);

    void deletePerson(Integer id);

    void deletePersonByPesel(String pesel);

    Boolean checkIfExist(Integer id);

}
