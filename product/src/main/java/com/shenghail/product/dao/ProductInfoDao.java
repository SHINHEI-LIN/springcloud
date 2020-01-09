package com.shenghail.product.dao;

import com.shenghail.product.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findProductInfoByProductIdIn(List<String> productIdList);

    ProductInfo findByProductId(String productId);
}