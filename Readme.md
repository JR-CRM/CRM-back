##CRM-back

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b32a3ca391b745b0b91bdfa60672c960)](https://www.codacy.com/gh/JR-CRM/CRM-back/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JR-CRM/CRM-back&amp;utm_campaign=Badge_Grade)



Set config files:

via VM options:

-Dspring.config.location=classpath:/application.properties,classpath:/sql-query.properties

or via program arguments:

--spring.config.location=classpath:/application.properties,classpath:/sql-query.properties







###Для настройки PostgreSQL

1) Скачать сервер баз данных - https://www.postgresql.org/download/
2) Установить его
3) Создать в нём базу данных, например crm
4) Подключить в IDEA созданную базу данных (по аналогии https://javastudy.ru/wp-content/uploads/2015/09/MySQL-connection-setting.png)
5) Настроить название базы, логин и пароль от базы данных в application.properties под себя
6) Выполнить postgresql-init.sql для первоначальной разметки таблиц
7) Опционально: выполнить postgresql-test-data.sql - для заполнения таблиц тестовыми данными
8) Перед продакшеном - снова пересоздать таблицы (пункт 6).
