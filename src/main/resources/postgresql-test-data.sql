--
-- Тестовые данные
--

INSERT INTO customer (id, name, phonenumber, email)
VALUES (1, 'Peter', '79001582323', 'pet@mail.ru'),
       (2, 'Vasil', '79001584545', 'v@mail.ru'),
       (3, 'Serg', '79003402023', 'serg@mail.ru');

INSERT INTO dictionary (code, name)
VALUES ('NEW', 'Новый'),
       ('IN_WORK', 'В работе'),
       ('COMPLETED', 'Завершен'),
       ('REJECTED', 'Отказ');