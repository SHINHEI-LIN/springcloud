package com.shenghail.product.dao;

import com.shenghail.product.model.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    void findByProductStatus() {
        List<ProductInfo> byProductStatus = productInfoDao.findByProductStatus(0);
        Assert.assertTrue(byProductStatus.size() > 0);
    }
}