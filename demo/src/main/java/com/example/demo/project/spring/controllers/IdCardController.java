package com.example.demo.project.spring.controllers;


import com.example.demo.project.spring.entities.IdCard;
import com.example.demo.project.spring.entities.Person;
import com.example.demo.project.spring.services.IdCardService;
import com.sun.istack.NotNull;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:4200")
public class IdCardController {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");

    @Autowired
    private IdCardService idCardService;

    @RequestMapping(value = "/id_card/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<IdCard> listIdCard(@PathVariable("id") Integer id) {
        return idCardService.findIdCardById(id);
    }

    @RequestMapping(value = "/id_card", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<IdCard> listIdCards(Model model) {
        return idCardService.listAllIdCards();
    }

    @RequestMapping(value = "/id_card/expired/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IdCard> listIdCardsExpired(@RequestParam("date") Optional<Date> date) {
        return idCardService.listExpiredIdCards(date.orElse(Date.valueOf(LocalDate.now().format(dtf))));
    }

    @RequestMapping(value = "/id_card", method = RequestMethod.POST)
    public ResponseEntity<IdCard> addIdCard(@RequestBody @Validated @NotNull IdCard idCard) {
        idCardService.addCard(idCard);
        return ResponseEntity.ok().body(idCard);
    }

    @RequestMapping(value = "/id_card/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteById(HttpServletResponse response, @PathVariable Integer id) {
        idCardService.deleteIdCard(id);
        return new RedirectView("/app/id_card", true);
    }

    @RequestMapping(value = "/id_card", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Validated @NotNull IdCard idCard) {
        if(!idCardService.checkIfExists(idCard.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            idCardService.addCard(idCard);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
