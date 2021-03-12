package ru.ldwx.crm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ldwx.crm.model.PersonDto;
import ru.ldwx.crm.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/crm/api/v1")
public class PersonController {
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/persons")
    public List<PersonDto> getAll() {
        return service.getAll();
    }
}
