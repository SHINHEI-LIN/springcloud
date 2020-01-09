package com.shenghail.order.controller;

import com.shenghail.order.client.ProductClient;
import com.shenghail.order.dto.OrderDTO;
import com.shenghail.order.model.ProductInfo;
import com.shenghail.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderService orderService;

    @GetMapping("/productList")
    public String getProductList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("23864292922323", "32378467392233"));
        log.info("productList: ", productInfoList);
        return "ok";
    }

    /**
     * 创建新订单
     * @param orderDTO
     * @return
     */
    @PostMapping("/createOrder")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }
}
