package com.example.demo.project.spring.repositories;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.swing.text.html.Option;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PersonRepo extends CrudRepository<Person, Integer>, PagingAndSortingRepository<Person, Integer> {

    Person findPersonByPesel(String pesel);

    @Query(value = "DELETE FROM people WHERE pesel = ?1", nativeQuery = true)
    void deletePersonByPesel(String pesel);

    List<Person> findDistinctPersonByBirthplace(City city);

    @Query(value = "SELECT COUNT(*) from people where id = ?1", nativeQuery = true)
    Integer checkIfExist(Integer id);
}
