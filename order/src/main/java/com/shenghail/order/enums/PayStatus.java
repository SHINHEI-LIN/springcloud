package com.shenghail.order.enums;

import lombok.Getter;

@Getter
public enum PayStatus {
    UN_PAY(0, "未支付"),
    PAY_SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String desc;

    PayStatus(Integer _code, String _desc) {
        code = _code;
        desc = _desc;
    }
}
