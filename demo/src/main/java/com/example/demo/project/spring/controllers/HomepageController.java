package com.example.demo.project.spring.controllers;

import com.example.demo.project.spring.entities.City;
import com.example.demo.project.spring.entities.IdCard;
import com.example.demo.project.spring.entities.IssuingAuthority;
import com.example.demo.project.spring.entities.Person;
import com.example.demo.project.spring.services.CityService;
import com.example.demo.project.spring.services.IssuingAuthorityService;
import com.example.demo.project.spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class HomepageController {

    @Autowired
    private PersonService personService;

    @Autowired
    private CityService cityService;

    @Autowired
    private IssuingAuthorityService issuingAuthorityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index()
    {
        return "index";
    }

    @RequestMapping(value = "/generateExample", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateExample() {

        IssuingAuthority issuingAuthority1 = new IssuingAuthority("Prezydent Miasta Poznań");
        IssuingAuthority issuingAuthority2 = new IssuingAuthority("Prezydent Miasta Warszawa");
        IssuingAuthority issuingAuthority3 = new IssuingAuthority("Prezydent Miasta Piła");
        IssuingAuthority issuingAuthority4 = new IssuingAuthority("Prezydent Miasta Bydgoszcz");
        IssuingAuthority issuingAuthority5 = new IssuingAuthority("Prezydent Miasta Zakopane");
        IssuingAuthority issuingAuthority6 = new IssuingAuthority("Wójt Gminy Ujście");

        City city1 = new City("Poznań", "Poland", "Wielkopolskie", "61-000");
        City city2 = new City("Warszawa", "Poland", "Mazowieckie", "00-000");
        City city3 = new City("Piła", "Poland", "Wielkopolskie", "64-920");
        City city4 = new City("Bydgoszcz", "Poland", "Kujawsko-Pomorskie", "85-000");
        City city5 = new City("Zakopane", "Poland", "Małopolskie", "34-500");
        City city6 = new City("Ujście", "Poland", "Wielkopolskie", "64-850");
        City city7 = new City("Byszki", "Poland", "Wielkopolskie", "64-850");

        Person person1 = new Person("97021714229" , "Magda", "Kozik", "Krzysztof", "Aleksandra", null);
        Person person2 = new Person("06310256366" , "Anna", "Mora", "Adam", "Marta", null);
        Person person3 = new Person("36101183456", "Bartosz", "Kozioł", "Andrzej", "Hanna", null);
        Person person4 = new Person("21101973189", "Wojciech", "Kowalski", "Janusz", "Kamila", null);
        Person person5 = new Person("45040363724", "Aleksandra", "Biała", "Oskar", "Krystyna", null);
        Person person6 = new Person("80042719272", "Adam", "Lewy", "Jan", "Anna", null);
        Person person7 = new Person("73071855952", "Marek", "Walejczyk", "Piotr", "Maria", null);
        Person person8 = new Person("69052055437", "Aleksander", "Drzewczyk", "Marian", "Oliwia", null);
        Person person9 = new Person("01322185248", "Balbina", "Ziółkowska", "Tymoteusz", "Sabina", null);
        Person person10 = new Person("67080689488", "Żorżeta", "Niebyła", "Ksawery", "Rajmunda", null);

        /*

        IssuingAuthority issuingAuthority1 = new IssuingAuthority("Prezydent Miasta Poznań", List.of(city1));
        IssuingAuthority issuingAuthority2 = new IssuingAuthority("Prezydent Miasta Warszawa", List.of(city2));
        IssuingAuthority issuingAuthority3 = new IssuingAuthority("Prezydent Miasta Piła", List.of(city3));
        IssuingAuthority issuingAuthority4 = new IssuingAuthority("Prezydent Miasta Bydgoszcz", List.of(city4));
        IssuingAuthority issuingAuthority5 = new IssuingAuthority("Prezydent Miasta Zakopane", List.of(city5));
        IssuingAuthority issuingAuthority6 = new IssuingAuthority("Wójt Gminy Ujście", List.of(city6, city7));


         */

        IdCard idCard1 = new IdCard(person1, LocalDate.parse("2017-12-07"), issuingAuthority1);
        //IdCard idCard2 = new IdCard(person2, LocalDate.parse("2017-12-07"), issuingAuthority1);
        IdCard idCard3 = new IdCard(person3, LocalDate.parse("2015-04-11"), issuingAuthority3);
        IdCard idCard4 = new IdCard(person4, LocalDate.parse("2011-02-24"), issuingAuthority4);
        IdCard idCard5 = new IdCard(person5, LocalDate.parse("2013-11-01"), issuingAuthority5);
        IdCard idCard6 = new IdCard(person6, LocalDate.parse("2019-01-16"), issuingAuthority6);
        IdCard idCard7 = new IdCard(person7, LocalDate.parse("2012-07-23"), issuingAuthority6);
        IdCard idCard8 = new IdCard(person8, LocalDate.parse("2015-03-07"), issuingAuthority2);
        IdCard idCard9 = new IdCard(person9, LocalDate.parse("2020-02-03"), issuingAuthority6);
        IdCard idCard10 = new IdCard(person10, LocalDate.parse("2013-05-22"), issuingAuthority4);

        person1.setBirthplace(city1);
        person2.setBirthplace(city2);
        person3.setBirthplace(city3);
        person4.setBirthplace(city4);
        person5.setBirthplace(city5);
        person6.setBirthplace(city6);
        person7.setBirthplace(city7);
        person8.setBirthplace(city2);
        person9.setBirthplace(city7);
        person10.setBirthplace(city4);

        city1.setIssuingAuthority(issuingAuthority1);
        city2.setIssuingAuthority(issuingAuthority2);
        city3.setIssuingAuthority(issuingAuthority3);
        city4.setIssuingAuthority(issuingAuthority4);
        city5.setIssuingAuthority(issuingAuthority5);
        city6.setIssuingAuthority(issuingAuthority6);
        city7.setIssuingAuthority(issuingAuthority6);

        person1.setIdCard(idCard1);
        //person2.setIdCard(idCard2);
        person3.setIdCard(idCard3);
        person4.setIdCard(idCard4);
        person5.setIdCard(idCard5);
        person6.setIdCard(idCard6);
        person7.setIdCard(idCard7);
        person8.setIdCard(idCard8);
        person9.setIdCard(idCard9);
        person10.setIdCard(idCard10);

        cityService.addCity(city1);
        cityService.addCity(city2);
        cityService.addCity(city3);
        cityService.addCity(city4);
        cityService.addCity(city5);
        cityService.addCity(city6);
        cityService.addCity(city7);

        personService.savePerson(person1);
        personService.savePerson(person2);
        personService.savePerson(person3);
        personService.savePerson(person4);
        personService.savePerson(person5);
        personService.savePerson(person6);
        personService.savePerson(person7);
        personService.savePerson(person8);
        personService.savePerson(person9);
        personService.savePerson(person10);

        return "Done";
    }


}
