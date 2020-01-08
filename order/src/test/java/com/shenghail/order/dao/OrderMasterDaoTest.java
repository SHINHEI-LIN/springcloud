package com.shenghail.order.dao;

import com.shenghail.order.dao.OrderMasterDao;
import com.shenghail.order.enums.OrderStatus;
import com.shenghail.order.enums.PayStatus;
import com.shenghail.order.model.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
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
class OrderMasterDaoTest{
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2763278263782");
        orderMaster.setBuyerOpenId("283hfdds2j2jk3h28172");
        orderMaster.setBuyerName("凌海");
        orderMaster.setBuyerPhone("1829342057");
        orderMaster.setBuyerAddress("北京市昌平区");
        orderMaster.setOrderAccount(new BigDecimal(100));
        orderMaster.setOrderStatus(OrderStatus.NEW_ORDER);
        orderMaster.setPayStatus(PayStatus.UN_PAY);
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        OrderMaster save = orderMasterDao.save(orderMaster);
        System.out.println(save);
    }
}