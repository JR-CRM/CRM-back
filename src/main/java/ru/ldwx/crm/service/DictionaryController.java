package ru.ldwx.crm.service;

import java.util.List;

//Использует DictionaryRepository для получения статусов
public interface DictionaryController {
    //Возвращает все статусы, будут использованы для выпадающего списка
    List<String> getAllStatuses();

    //Возвращает все статусы и дополнительно "Все статусы", будет использоваться для фильтров.
    List<String> getAllStatusFilters();
}
