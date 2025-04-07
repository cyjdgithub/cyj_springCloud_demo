package com.ncy.services.order.service;

import com.ncy.order.bean.Order;

public interface OrderService {
    Order createOrder(Long productId,Long userId);
}
