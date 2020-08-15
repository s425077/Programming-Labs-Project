package com.example.demo.project.spring.controllers;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.Person;
import com.example.demo.project.spring.repositories.CityRepo;
import com.example.demo.project.spring.services.CityService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping(value = "/cities/page/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<City> listPage(@PathVariable("page") Integer page, @RequestParam("pageSize") Optional<Integer> pageSize) {
        return cityService.listAllCitiesPageable(PageRequest.of(page, pageSize.orElse(5)));
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<City> listAll(Model model) {
        return cityService.listAllCities();
    }

    @RequestMapping(value = "/cities/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> listAllPeople(@PathVariable("id") Integer id) {
        return cityService.listAllPeopleFromCity(id);
    }

    @RequestMapping(value = "/cities/city/{city_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<City> findCityById(@PathVariable("city_id") Integer id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/cities/cityname/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> listByName(@PathVariable("name") String name) {
        return cityService.findCitiesByName(name);
    }

    @RequestMapping(value = "/cities/citycountry/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> listByCountry(@PathVariable("country") String country) {
        return cityService.findCitiesByCountry(country);
    }

    @RequestMapping(value = "/cities/citypostal/{postal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public City listByPostalCode(@PathVariable("postal") String postal) {
        return cityService.findCityByPostalCode(postal);
    }

    @RequestMapping(value = "/cities/", method = RequestMethod.POST)
    public ResponseEntity<City> addCity(@RequestBody @Validated @NotNull City city) {
        cityService.addCity(city);
        return ResponseEntity.ok().body(city);
    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteById(HttpServletResponse response, @PathVariable Integer id) {
         cityService.deleteCity(id);
        return new RedirectView("/app/cities", true);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Validated @NotNull City city) {
        if(!cityService.checkIfExist(city.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            cityService.addCity(city);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
