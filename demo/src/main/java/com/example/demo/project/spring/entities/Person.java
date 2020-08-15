package com.example.demo.project.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.lang.Character;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PEOPLE")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "PESEL", nullable = false, unique = true, length = 11)
    private String pesel;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "father_name")
    private String fatherName;
    
    @Column(name = "mother_name")
    private String motherName;
    
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "birthplace_id")
    private City birthplace;

    @OneToOne(cascade = CascadeType.ALL)
    private IdCard idCard;

    public Person() {}

    public Person(String pesel, String firstName, String lastName, String fatherName, String motherName, City birthplace) {
        if (checkPesel(pesel))
            this.pesel = pesel;
        else
            throw new IllegalArgumentException("wrong PESEL number " + pesel);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.birthdate = convertPeselToDate(pesel);
        this.birthplace = birthplace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public City getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(City birthplace) {
        this.birthplace = birthplace;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    private Boolean checkPesel(String pesel) {
        char[] peselTokenized = pesel.toCharArray();
        int sum = 0;
        int i = 1;

        for (char number: peselTokenized) {
            if (i > 11)
                return false;
            if (i == 1 || i == 5 || i == 9 || i == 11)
                sum = sum + number;
            else if (i == 2 || i == 6 || i == 10)
                sum = sum + 3*number;
            else if (i == 3 || i == 7)
                sum = sum + 7*number;
            else if (i == 4 || i == 8)
                sum = sum + 9*number;
            i++;
        }

        return sum % 10 == 0;
    }

    private LocalDate convertPeselToDate(String pesel) {
        char[] peselToken = pesel.toCharArray();
        int year = 0, month = 0, day = 0;

        year = toInt(peselToken[0]) * 10 + toInt(peselToken[1]);
        day = toInt(peselToken[4]) * 10 + toInt(peselToken[5]);

        if (toInt(peselToken[2]) < 2) {
            year = year + 1900;
            month = toInt(peselToken[2]) * 10 + toInt(peselToken[3]);
            System.out.println(month);
        }
        else if (toInt(peselToken[2]) < 4) {
            year = year + 2000;
            month = toInt(peselToken[2]) * 10 + toInt(peselToken[3]) - 20;
        }
        else if (toInt(peselToken[2]) < 6) {
            year = year + 2100;
            month = toInt(peselToken[2]) * 10 + toInt(peselToken[3]) - 40;
        }
        else if (toInt(peselToken[2]) < 8) {
            year = year + 2200;
            month = toInt(peselToken[2]) * 10 + toInt(peselToken[3]) - 60;
        }
        else if (toInt(peselToken[2]) < 10) {
            year = year + 1800;
            month = toInt(peselToken[2]) * 10 + toInt(peselToken[3]) - 80;
        }

        return LocalDate.of(year, month, day);
    }

    private Integer toInt(char c) {
        return Character.getNumericValue(c);
    }
}
