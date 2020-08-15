package com.example.demo.project.spring.services;

import com.example.demo.project.spring.entities.IdCard;
import com.example.demo.project.spring.repositories.IdCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IdCardServiceImpl implements IdCardService {

    @Autowired
    private IdCardRepo idCardRepo;

    @Override
    public Optional<IdCard> findIdCardById(Integer id) {
        return idCardRepo.findById(id);
    }

     /*

    @Override
    public IdCard findIdCardByPesel(String pesel) {
        return idCardRepo.findIdCardByPesel(pesel);
    }

     */

    @Override
    public Iterable<IdCard> listAllIdCards() {
        return idCardRepo.findAll();
    }

    @Override
    public List<IdCard> listExpiredIdCards(Date currentDate) {
        return idCardRepo.listExpiredIdCards(currentDate);
    }

    @Override
    public IdCard addCard(IdCard idCard) {
        return idCardRepo.save(idCard);
    }

    @Override
    public void deleteIdCard(Integer id) {
        idCardRepo.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        return idCardRepo.checkIfExist(id) > 0;
    }
}
