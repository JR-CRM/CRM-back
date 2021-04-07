package ru.ldwx.crm.data;

import ru.ldwx.crm.model.StatusDto;
import ru.ldwx.crm.model.StatusEntity;

import java.util.List;

public class StatusTestData {

    public static List<StatusEntity> getAllStatusEntities() {
        return List.of(new StatusEntity("NEW", "Новый"),
                new StatusEntity("IN_WORK", "В работе"),
                new StatusEntity("COMPLETED", "Завершен"),
                new StatusEntity("REJECTED", "Отказ"))
        ;
    }

    public static List<StatusDto> getAllStatusDtos() {
        return List.of(new StatusDto("NEW", "Новый"),
                new StatusDto("IN_WORK", "В работе"),
                new StatusDto("COMPLETED", "Завершен"),
                new StatusDto("REJECTED", "Отказ"));
    }

    public static List<StatusDto> getAllStatusDtoFilters() {
        return List.of(new StatusDto("All", "Statuses"),
                new StatusDto("NEW", "Новый"),
                new StatusDto("IN_WORK", "В работе"),
                new StatusDto("COMPLETED", "Завершен"),
                new StatusDto("REJECTED", "Отказ"));
    }
}
