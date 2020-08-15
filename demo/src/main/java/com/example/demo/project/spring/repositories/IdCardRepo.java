package com.example.demo.project.spring.repositories;

import com.example.demo.project.spring.entities.IdCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IdCardRepo extends CrudRepository<IdCard, Integer> {

    //IdCard findIdCardByPesel(String pesel);

    @Query(value = "SELECT i FROM id_card i WHERE i.expiry_date < ?1", nativeQuery = true)
    List<IdCard> listExpiredIdCards(Date currentDate);

    @Query(value = "SELECT COUNT(*) from id_card WHERE id = ?1", nativeQuery = true)
    Integer checkIfExist(Integer Id);

}
