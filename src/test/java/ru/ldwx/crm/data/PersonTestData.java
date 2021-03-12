package ru.ldwx.crm.data;

import ru.ldwx.crm.model.PersonDto;
import ru.ldwx.crm.model.PersonEntity;

import java.util.List;

public class PersonTestData {
    public static List<PersonEntity> getAllPersonEntities() {
        return List.of(new PersonEntity(1L, "Peter", 18),
                new PersonEntity(2L, "Vasil", 22),
                new PersonEntity(3L, "Serg", 25));
    }

    public static List<PersonDto> getAllPersonDtos() {
        return List.of(new PersonDto(1L, "Peter", 18),
                new PersonDto(2L, "Vasil", 22),
                new PersonDto(3L, "Serg", 25));
    }
}
