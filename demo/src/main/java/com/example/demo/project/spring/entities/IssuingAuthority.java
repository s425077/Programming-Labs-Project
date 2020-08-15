package com.example.demo.project.spring.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ISSUING_AUTHORITY")
public class IssuingAuthority {

    @Id
    @GeneratedValue(generator = "gen_auth")
    @SequenceGenerator(name = "gen_auth", sequenceName = "auth_seq")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "issuingAuthority")
    private List<City> city;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "issuingAuthority")
    private List<IdCard> idCards;

    public IssuingAuthority() {}

    public IssuingAuthority(String name) {
        this.name = name;
    }

    public IssuingAuthority(String name, List<City> city) {
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
