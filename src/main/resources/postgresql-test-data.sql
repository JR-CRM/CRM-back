--
-- Тестовые данные
--

INSERT INTO customer (name, phonenumber, email)
VALUES ('Peter', '79001582323', 'pet@mail.ru'),
       ('Vasil', '79001584545', 'v@mail.ru'),
       ('Serg', '79003402023', 'serg@mail.ru');




INSERT INTO order_supplier (order_number, goods_list, order_date, order_cost, delivery_date, comment)
VALUES ('№0001', 'набор для кукл 1', '2021.01.01', '700 евро', '2021.06.01', 'Не забыть купить ещё пива и крыльев'),
       ('#0002-KFC', 'Крылья и Пиво', '07.07.2021', '300 рублей', '07.07.2021', 'вместо обеда'),
       ('0003-Tesla', 'ModelS', '18.03.2020', '$72.24', '2021/04/04', 'акции могут подорожать!');



