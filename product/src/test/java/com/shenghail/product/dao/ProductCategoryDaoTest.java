package com.shenghail.product.dao;

import com.shenghail.product.model.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    void findByCategoryTypesIn() {
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList.add(33);
        List<ProductCategory> byCategoryTypesIn = productCategoryDao.findByCategoryTypeIn(categoryTypeList);
        Assert.assertTrue(byCategoryTypesIn.size() > 0);

    }
}