package com.example.demo.project.spring.services;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CityService {

    Page<City> listAllCitiesPageable(Pageable pageable);

    Iterable<City> listAllCities();

    List<Person> listAllPeopleFromCity(Integer id);

    List<City> findCitiesByName(String name);

    List<City> findCitiesByCountry(String country);

    City findCityByPostalCode(String postalCode);

    Optional<City> findCityById(Integer id);

    City addCity(City city);

    void deleteCity(Integer id);

    Boolean checkIfExist(Integer id);

}
