package ru.ldwx.crm.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.ldwx.crm.TestEnvironmentConfiguration;
import ru.ldwx.crm.data.PersonTestData;
import ru.ldwx.crm.service.PersonService;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = TestEnvironmentConfiguration.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService service;

    @BeforeEach
    void init() {
        given(service.getAll()).willReturn(PersonTestData.getAllPersonDtos());
    }

    @Test
    void getAllPersonsShouldWork() throws Exception {
        mvc.perform(get("/crm/api/v1/persons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Peter")))
                .andExpect(jsonPath("$[1].name", is("Vasil")))
                .andExpect(jsonPath("$[2].name", is("Serg")));
    }
}