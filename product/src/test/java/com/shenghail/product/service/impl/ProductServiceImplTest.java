package com.shenghail.product.service.impl;

import com.shenghail.product.model.ProductInfo;
import com.shenghail.product.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void findAllProduct() {
        List<ProductInfo> allProduct = productService.findAllProduct();
        Assert.assertTrue(allProduct.size() > 0);
    }
}