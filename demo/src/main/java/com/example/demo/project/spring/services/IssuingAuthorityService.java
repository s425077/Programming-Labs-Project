package com.example.demo.project.spring.services;

import com.example.demo.project.spring.entities.IssuingAuthority;

import java.util.Optional;

public interface IssuingAuthorityService {

    Iterable<IssuingAuthority> listAllIssuingAuthorities();

    Optional<IssuingAuthority> findIssuingAuthorityById(Integer id);

    IssuingAuthority findIssuingAuthorityByName(String name);

    IssuingAuthority addIssuingAuthority(IssuingAuthority issuingAuthority);

    void deleteIssuingAuthority(Integer id);

    Boolean checkIfExists(Integer id);

}
