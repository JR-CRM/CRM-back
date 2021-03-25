package ru.ldwx.crm.data;

import ru.ldwx.crm.model.StatusEntity;

import java.util.List;

public class StatusTestData {

    public static List<StatusEntity> getAllStatuses() {
        return List.of(new StatusEntity(1, "Новый"),
                new StatusEntity(2, "В работе"),
                new StatusEntity(3, "Завершен"));
    }
}
