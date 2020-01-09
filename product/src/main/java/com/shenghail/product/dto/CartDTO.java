package com.shenghail.product.dto;

import lombok.Data;

/**
 * 减库存DTO
 */
@Data
public class CartDTO {
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String _productId, Integer _productQuantity) {
        this.productId = _productId;
        this.productQuantity = _productQuantity;
    }
}
