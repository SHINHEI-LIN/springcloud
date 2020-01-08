package com.shenghail.order.dao;

import com.shenghail.order.model.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;


@Component
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("237893479374");
        orderDetail.setOrderId("2763278263782");
        orderDetail.setProductId("38437249327493");
        orderDetail.setProductName("小米粥");
        orderDetail.setProductPrice(new BigDecimal(3.00));
        orderDetail.setProductQuantity(2);
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());
        OrderDetail save = orderDetailDao.save(orderDetail);
        System.out.println(save);
    }
}