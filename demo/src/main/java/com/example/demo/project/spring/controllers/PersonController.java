package com.example.demo.project.spring.controllers;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import com.example.demo.project.spring.services.PersonService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/people/page/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Person> listPage(@PathVariable("page") Integer page, @RequestParam("pageSize") Optional<Integer> pageSize) {
        return personService.findAllPeople(PageRequest.of(page, pageSize.orElse(5)));
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> listAll(Model model) {
        return personService.listAllPeople();
    }

    @RequestMapping(value = "/people/city/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> listByCity(@PathVariable("city") City city) {
        return personService.listAllPeopleByBirthplace(city);
    }

    @RequestMapping(value = "/people/pesel/{pesel}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person listByPesel(@PathVariable("pesel") String pesel) {
        return personService.findPersonByPesel(pesel);
    }

    @RequestMapping(value = "/people/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Person> listByPesel(@PathVariable("id") Integer id) {
        return personService.findPersonById(id);
    }

    @RequestMapping(value = "/people/", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@RequestBody @Validated @NotNull Person person) {
        personService.savePerson(person);
        return ResponseEntity.ok().body(person);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteById(HttpServletResponse response, @PathVariable Integer id) {
        personService.deletePerson(id);
        return new RedirectView("/app/people", true);
    }

    @RequestMapping(value = "/people/pesel/{pesel}", method = RequestMethod.DELETE)
    public RedirectView deleteByPesel(HttpServletResponse response, @PathVariable String pesel) {
        personService.deletePersonByPesel(pesel);
        return new RedirectView("/app/people", true);
    }

    @RequestMapping(value = "/people", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Validated @NotNull Person person) {
        if(!personService.checkIfExist(person.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            personService.savePerson(person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
