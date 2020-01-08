package com.shenghail.product.service;

import com.shenghail.product.model.ProductInfo;
import java.util.List;

public interface ProductService {
    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findAllProduct();
}
