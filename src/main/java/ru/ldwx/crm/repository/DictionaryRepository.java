package ru.ldwx.crm.repository;

import java.util.List;

public interface DictionaryRepository {
    // Считывает из базы данных все варианты статусов заказа (Новый, В работе, Завершен, Отказ)
    List<String> getAllStatuses();
}
