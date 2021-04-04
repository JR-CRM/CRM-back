
--
-- Первоначальное создание таблиц
--

DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer
(
--     id   BIGSERIAL PRIMARY KEY NOT NULL,
    id  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR (255),
    phonenumber VARCHAR (255),
    email VARCHAR (255)
);




DROP TABLE IF EXISTS order_supplier;

CREATE TABLE order_supplier
(
    id  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    order_number  VARCHAR (255),
    goods_list   TEXT,
    order_date   VARCHAR (255),
    order_cost   VARCHAR (255),
    delivery_date    VARCHAR (255),
    comment VARCHAR (255)
);