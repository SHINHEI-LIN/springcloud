package com.shenghail.order.service.impl;

import com.shenghail.order.dto.OrderDTO;
import com.shenghail.order.model.OrderDetail;
import com.shenghail.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("凌海");
        orderDTO.setBuyerPhone("18829342057");
        orderDTO.setBuyerAddress("北京市昌平区");
        orderDTO.setBuyerOpenId("3483jdh43dj3j3j3h4gh43j");
        List<OrderDetail> orderDetailList = new ArrayList<>(1);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("32378467392233");
        orderDetail.setProductQuantity(10);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        orderService.create(orderDTO);
    }
}