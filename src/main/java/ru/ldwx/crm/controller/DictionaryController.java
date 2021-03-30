package ru.ldwx.crm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ldwx.crm.model.StatusDto;
import ru.ldwx.crm.service.DictionaryService;
import java.util.List;

@RestController
@RequestMapping("/crm/api/v1")
public class DictionaryController {

    private DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @ResponseBody
    @GetMapping("/statuses")
    public List<StatusDto> getAllStatuses(){
        return dictionaryService.getAllStatuses();
    }


}
