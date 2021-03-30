
--
-- Первоначальное создание таблиц
--

DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer
(
    id   BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR (255),
    phonenumber VARCHAR (255),
    email VARCHAR (255)
);