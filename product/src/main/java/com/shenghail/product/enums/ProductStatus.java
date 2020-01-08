package com.shenghail.product.enums;

/**
 * 商品状态
 */
public enum ProductStatus {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;

    private Integer code;
    private String desc;

    ProductStatus(Integer _code, String _desc) {
        this.code = _code;
        this.desc = _desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}