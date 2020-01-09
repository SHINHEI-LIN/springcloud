package com.shenghail.order.service;

import com.shenghail.order.dto.OrderDTO;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
}
