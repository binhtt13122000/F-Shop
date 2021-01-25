package com.dev.fshop.services.impl;

import com.dev.fshop.entities.Orders;
import com.dev.fshop.repositories.OrdersRepository;
import com.dev.fshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders findOrderByOrderId(String orderId) {
        return ordersRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Orders> getOrdersByProductIdAndUserId(String productId, String userId) {
        return ordersRepository.getOrdersByProductIdAndUserIdAndStatus(productId, userId, 0);
    }
}
