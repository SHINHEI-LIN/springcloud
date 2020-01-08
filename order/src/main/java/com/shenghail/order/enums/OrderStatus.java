package com.shenghail.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    NEW_ORDER(0, "新订单"),
    ORDER_SUCCESS(1, "订单完成"),
    ORDER_CANCEL(2, "订单取消"),
    ;

    private Integer code;
    private String desc;

    OrderStatus(Integer _code, String _desc) {
        code = _code;
        desc = _desc;
    }
}
