package ru.ldwx.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ldwx.crm.model.OrderSupplierEntity;
import ru.ldwx.crm.repository.OrderSupplierRepository;

/*
 *  Для тестирования, потом или удалим, или заменим на REST
 *  Класс нужен, чтобы можно было "пощупать" в браузере
 *  работу с Заказами.
 */
@Controller
public class OrderSupplierController {

    private OrderSupplierRepository orderSupplierRepository;

    public OrderSupplierController(OrderSupplierRepository orderSupplierRepository) {
        this.orderSupplierRepository = orderSupplierRepository;
    }


    @GetMapping("/order_supplier")
    public String show(Model model) {

        Iterable<OrderSupplierEntity> orders = orderSupplierRepository.findAll();
        model.addAttribute("order_supplier", orders);

        return "order_supplier";
    }


    @PostMapping("/order_supplier")
    public String add(
            @RequestParam String orderNumber,
            @RequestParam String goodsList,
            @RequestParam String orderDate,
            @RequestParam String orderCost,
            @RequestParam String deliveryDate,
            @RequestParam String comment,
            Model model
    ) {
        OrderSupplierEntity orderEntity = new OrderSupplierEntity(orderNumber, goodsList, orderDate, orderCost, deliveryDate, comment);
        orderSupplierRepository.save(orderEntity);

        Iterable<OrderSupplierEntity> orders = orderSupplierRepository.findAll();
        model.addAttribute("order_supplier", orders);

        return "order_supplier";
    }
}
