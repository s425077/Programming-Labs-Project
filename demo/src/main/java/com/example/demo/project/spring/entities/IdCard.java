package com.example.demo.project.spring.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "ID_CARD")
public class IdCard {

    @Id
    @GeneratedValue(generator = "gen_card")
    @SequenceGenerator(name = "gen_card", sequenceName = "card_seq")
    private Integer id;

    @Column(name = "card_id")
    private String cardId;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "issuingAuthority_id")
    private IssuingAuthority issuingAuthority;

    public IdCard() {}

    public IdCard(String cardId, Person person, LocalDate dateOfIssue, IssuingAuthority issuingAuthority) {
        this.cardId = cardId;
        this.person = person;
        this.dateOfIssue = dateOfIssue;
        this.expiryDate = generateExpiryDate(dateOfIssue);
        this.issuingAuthority = issuingAuthority;
    }

    public IdCard(Person person, LocalDate dateOfIssue, IssuingAuthority issuingAuthority) {
        this.cardId = generateCardId();
        this.person = person;
        this.dateOfIssue = dateOfIssue;
        this.expiryDate = generateExpiryDate(dateOfIssue);
        this.issuingAuthority = issuingAuthority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /*
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    */

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public IssuingAuthority getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(IssuingAuthority issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    private String generateCardId() {
        int letters = 3;
        int digits = 6;

        String letterPart = RandomStringUtils.randomAlphabetic(letters).toUpperCase();
        String digitsPart = RandomStringUtils.randomNumeric(digits);

        return letterPart + digitsPart;
    }

    private Date generateExpiryDate(LocalDate dateOfIssue) {
        return java.sql.Date.valueOf(dateOfIssue.plusYears(10));
    }
}
