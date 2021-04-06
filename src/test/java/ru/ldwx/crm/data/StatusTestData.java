package ru.ldwx.crm.data;

import ru.ldwx.crm.model.StatusDto;
import ru.ldwx.crm.model.StatusEntity;

import java.util.List;

public class StatusTestData {

    public static List<StatusEntity> getAllStatusEntities() {
        return List.of(new StatusEntity("1", "Новый"),
                new StatusEntity("2", "В работе"),
                new StatusEntity("3", "Завершен"),
                new StatusEntity("4", "Отказ"))
        ;
    }

    public static List<StatusDto> getAllStatusDtos() {
        return List.of(new StatusDto("1", "Новый"),
                new StatusDto("2", "В работе"),
                new StatusDto("3", "Завершен"),
                new StatusDto("4", "Отказ"));
    }

    public static List<StatusDto> getAllStatusDtoFilters() {
        return List.of(new StatusDto("All", "Statuses"),
                new StatusDto("1", "Новый"),
                new StatusDto("2", "В работе"),
                new StatusDto("3", "Завершен"),
                new StatusDto("4", "Отказ"));
    }
}
