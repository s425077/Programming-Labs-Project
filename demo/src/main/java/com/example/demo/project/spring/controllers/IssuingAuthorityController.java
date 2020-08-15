package com.example.demo.project.spring.controllers;

import com.example.demo.project.spring.entities.IssuingAuthority;
import com.example.demo.project.spring.entities.Person;
import com.example.demo.project.spring.services.IssuingAuthorityService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:4200")
public class IssuingAuthorityController {

    @Autowired
    private IssuingAuthorityService issuingAuthorityService;

    @RequestMapping(value = "/authorities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<IssuingAuthority> listAll(Model model) {
        return issuingAuthorityService.listAllIssuingAuthorities();
    }

    @RequestMapping(value = "/authority", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<IssuingAuthority> listIssuingAuthorityById(Integer id) {
        return issuingAuthorityService.findIssuingAuthorityById(id);
    }

    @RequestMapping(value = "/authority/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public IssuingAuthority listIssuingAuthorityByName(String name) {
        return issuingAuthorityService.findIssuingAuthorityByName(name);
    }

    @RequestMapping(value = "/authority", method = RequestMethod.POST)
    public ResponseEntity<IssuingAuthority> addIssuingAuthority(@RequestBody @Validated @NotNull IssuingAuthority issuingAuthority) {
        issuingAuthorityService.addIssuingAuthority(issuingAuthority);
        return ResponseEntity.ok().body(issuingAuthority);
    }

    @RequestMapping(value = "/authority/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteById(HttpServletResponse response, @PathVariable Integer id) {
        issuingAuthorityService.deleteIssuingAuthority(id);
        return new RedirectView("/app/authorities", true);
    }

    @RequestMapping(value = "/authority", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Validated @NotNull IssuingAuthority issuingAuthority) {
        if(!issuingAuthorityService.checkIfExists(issuingAuthority.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            issuingAuthorityService.addIssuingAuthority(issuingAuthority);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
