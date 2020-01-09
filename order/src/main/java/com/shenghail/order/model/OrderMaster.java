package com.shenghail.order.model;

import com.shenghail.order.enums.OrderStatus;
import com.shenghail.order.enums.PayStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "order_master")
public class OrderMaster {
    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenId;
    private BigDecimal orderAccount;
    private Integer payStatus;
    private Integer orderStatus;
    private Date createTime;
    private Date updateTime;

}
