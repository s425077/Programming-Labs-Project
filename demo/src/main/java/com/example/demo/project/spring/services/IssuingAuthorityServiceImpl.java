package com.example.demo.project.spring.services;


import com.example.demo.project.spring.entities.IssuingAuthority;
import com.example.demo.project.spring.repositories.IssuingAuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssuingAuthorityServiceImpl implements IssuingAuthorityService {

    @Autowired
    private IssuingAuthorityRepo issuingAuthorityRepo;

    @Override
    public Iterable<IssuingAuthority> listAllIssuingAuthorities() {
        return issuingAuthorityRepo.findAll();
    }

    @Override
    public Optional<IssuingAuthority> findIssuingAuthorityById(Integer id) {
        return issuingAuthorityRepo.findById(id);
    }

    @Override
    public IssuingAuthority findIssuingAuthorityByName(String name) {
        return issuingAuthorityRepo.findIssuingAuthorityByName(name);
    }

    @Override
    public IssuingAuthority addIssuingAuthority(IssuingAuthority issuingAuthority) {
        return issuingAuthorityRepo.save(issuingAuthority);
    }

    @Override
    public void deleteIssuingAuthority(Integer id) {
        issuingAuthorityRepo.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        return issuingAuthorityRepo.checkIfExist(id) > 0;
    }
}
