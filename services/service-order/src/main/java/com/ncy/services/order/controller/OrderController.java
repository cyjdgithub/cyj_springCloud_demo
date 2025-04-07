package com.ncy.services.order.controller;

import com.ncy.order.bean.Order;
import com.ncy.services.order.properties.OrderProperties;
import com.ncy.services.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RefreshScope
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderProperties orderProperties;

    /*@Value("${order.timeout}")
    String orderTimeout;
    @Value("${order.auto-confirm}")
    String orderAutoConfirm;*/

    @GetMapping("/config")
    public String config(){
        return "order.timeout="+ orderProperties.getTimeout() +";auto.confirm"+orderProperties.getAutoConfirm();
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId
                             ){
        Order order = orderService.createOrder(productId,userId);
        return order;
    }
}
