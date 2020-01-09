package com.shenghail.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(-1001, "商品不存在"),
    PRODUCT_STOCK_ERROR(-1002, "库存错误"),
    ;
    private Integer code;
    private String desc;

    ResultEnum(Integer _code, String _desc) {
        this.code = _code;
        this.desc = _desc;
    }
}
