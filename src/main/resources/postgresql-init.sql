
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

DROP TABLE if EXISTS dictionary;

CREATE TABLE if NOT EXISTS dictionary
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    code VARCHAR (255) UNIQUE NOT NULL,
    name VARCHAR (255) UNIQUE NOT NULL
);