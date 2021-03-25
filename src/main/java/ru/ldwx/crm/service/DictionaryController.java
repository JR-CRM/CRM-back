package ru.ldwx.crm.service;

import ru.ldwx.crm.model.StatusDto;
import ru.ldwx.crm.model.StatusEntity;

import java.util.List;

//Использует DictionaryRepository для получения статусов
public interface DictionaryController {
    //Возвращает все статусы, будут использованы для выпадающего списка
    List<StatusDto> getAllStatuses();

    //Возвращает все статусы и дополнительно "Все статусы", будет использоваться для фильтров.
    List<StatusDto> getAllStatusFilters();
}
