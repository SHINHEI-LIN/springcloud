package com.shenghail.product.service.impl;

import com.shenghail.product.dao.ProductInfoDao;
import com.shenghail.product.enums.ProductStatus;
import com.shenghail.product.model.ProductInfo;
import com.shenghail.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    public List<ProductInfo> findAllProduct() {
        return productInfoDao.findByProductStatus(ProductStatus.UP.getCode());
    }
}