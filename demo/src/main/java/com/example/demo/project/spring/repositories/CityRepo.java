package com.example.demo.project.spring.repositories;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CityRepo extends CrudRepository<City, Integer>, PagingAndSortingRepository<City, Integer> {

    @Query(value = "SELECT registeredPeople from cities WHERE id = ?1", nativeQuery = true)
    List<Person> listAllPeopleFromCity(Integer id);

    List<City> findCityByName(String name);

    List<City> findCityByCountry(String country);

    City findCityByPostalCode(String postalCode);

    @Query(value = "SELECT COUNT(*) from cities WHERE id = ?1", nativeQuery = true)
    Integer checkIfExist(Integer Id);

}
