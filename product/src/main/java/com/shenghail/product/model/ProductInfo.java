package com.shenghail.product.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "product_info")
@Entity
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescript;
    private Integer productStatus;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}