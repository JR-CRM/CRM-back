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
import ru.ldwx.crm.data.StatusTestData;
import ru.ldwx.crm.service.DictionaryService;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = TestEnvironmentConfiguration.class)
public class DictionaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DictionaryService dictionaryService;

    @BeforeEach
    void init() {
        given(dictionaryService.getAllStatuses()).willReturn(StatusTestData.getAllStatusDtos());
    }

    @Test
    void getAllStatusesShouldWork() throws Exception {
        mvc.perform(get("/crm/api/v1/statuses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Новый")))
                .andExpect(jsonPath("$[1].name", is("В работе")))
                .andExpect(jsonPath("$[2].name", is("Завершен")));

    }
}
