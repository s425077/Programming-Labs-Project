package com.example.demo.project.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CITIES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name","postal_code"})})
public class City {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "city_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "birthplace")
    private List<Person> registeredPeople;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "issuingAuthority_id")
    private IssuingAuthority issuingAuthority;

    public City() {}

    public City(String name, String country, String region, String postalCode) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<Person> getRegisteredPeople() {
        return registeredPeople;
    }

    public void setRegisteredPeople(List<Person> registeredPeople) {
        this.registeredPeople = registeredPeople;
    }

    public IssuingAuthority getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(IssuingAuthority issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }
}
