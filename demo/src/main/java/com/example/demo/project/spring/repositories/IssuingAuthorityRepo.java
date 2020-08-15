package com.example.demo.project.spring.repositories;

import com.example.demo.project.spring.entities.IssuingAuthority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IssuingAuthorityRepo extends CrudRepository<IssuingAuthority, Integer> {

    IssuingAuthority findIssuingAuthorityByName(String name);

    @Query(value = "SELECT COUNT(*) from issuing_authority WHERE id = ?1", nativeQuery = true)
    Integer checkIfExist(Integer Id);
}
