package com.example.demo.project.spring.services;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import com.example.demo.project.spring.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public Page<Person> findAllPeople(Pageable pageable) {
        return personRepo.findAll(pageable);
    }

    @Override
    public Person findPersonByPesel(String pesel) { return personRepo.findPersonByPesel(pesel); }

    @Override
    public Optional<Person> findPersonById(Integer id) { return personRepo.findById(id); }

    @Override
    public List<Person> listAllPeopleByBirthplace(City city) {
        return personRepo.findDistinctPersonByBirthplace(city);
    }

    @Override
    public Iterable<Person> listAllPeople() {
        return personRepo.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepo.deleteById(id);
    }

    @Override
    public void deletePersonByPesel(String pesel) {
        personRepo.deletePersonByPesel(pesel);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (personRepo.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
