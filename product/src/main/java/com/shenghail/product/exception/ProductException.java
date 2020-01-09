package com.shenghail.product.exception;

import com.shenghail.product.enums.ResultEnum;

public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(String massage, Integer _code) {
        super(massage);
        code = _code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = resultEnum.getCode();
    }
}
