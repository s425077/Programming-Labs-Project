package com.example.demo.project.spring.services;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import com.example.demo.project.spring.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Override
    public Page<City> listAllCitiesPageable(Pageable pageable) {
        return cityRepo.findAll(pageable);
    }

    @Override
    public Iterable<City> listAllCities() {
        return cityRepo.findAll();
    }

    @Override
    public List<Person> listAllPeopleFromCity(Integer id) {
        return cityRepo.listAllPeopleFromCity(id);
    }

    @Override
    public List<City> findCitiesByName(String name) {
        return cityRepo.findCityByName(name);
    }

    @Override
    public List<City> findCitiesByCountry(String country) {
        return cityRepo.findCityByCountry(country);
    }

    @Override
    public City findCityByPostalCode(String postalCode) {
        return cityRepo.findCityByPostalCode(postalCode);
    }

    @Override
    public Optional<City> findCityById(Integer id) {
        return cityRepo.findById(id);
    }

    @Override
    public City addCity(City city) {
        return cityRepo.save(city);
    }

    @Override
    public void deleteCity(Integer id) {
        cityRepo.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return cityRepo.checkIfExist(id) > 0;
    }
}
