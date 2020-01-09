package com.shenghail.product.service;

import com.shenghail.product.dto.CartDTO;
import com.shenghail.product.exception.ProductException;
import com.shenghail.product.model.ProductInfo;
import java.util.List;

public interface ProductService {
    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findAllProduct();

    /**
     * 根据商品ID查询商品
     * @param productIdList
     * @return
     */
    List<ProductInfo> findProductInfoByProductIdIn(List<String> productIdList);

    /**
     * 减库存
     * @param cartDTO
     * @throws ProductException
     */
    void decreaseStock(List<CartDTO> cartDTO) throws ProductException;
}
