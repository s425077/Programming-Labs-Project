package com.example.demo.project.spring.services;

import com.example.demo.project.spring.entities.IdCard;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IdCardService {

    Optional<IdCard> findIdCardById(Integer id);

    //IdCard findIdCardByPesel(String pesel);

    Iterable<IdCard> listAllIdCards();

    List<IdCard> listExpiredIdCards(Date currentDate);

    IdCard addCard(IdCard idCard);

    void deleteIdCard(Integer id);

    Boolean checkIfExists(Integer id);

}
