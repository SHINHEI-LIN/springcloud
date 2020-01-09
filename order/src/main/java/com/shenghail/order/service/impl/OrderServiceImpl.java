package com.shenghail.order.service.impl;

import com.shenghail.order.client.ProductClient;
import com.shenghail.order.common.KeyUtils;
import com.shenghail.order.dao.OrderDetailDao;
import com.shenghail.order.dao.OrderMasterDao;
import com.shenghail.order.dto.CartDTO;
import com.shenghail.order.dto.OrderDTO;
import com.shenghail.order.enums.OrderStatus;
import com.shenghail.order.enums.PayStatus;
import com.shenghail.order.model.OrderDetail;
import com.shenghail.order.model.OrderMaster;
import com.shenghail.order.model.ProductInfo;
import com.shenghail.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.genUniqueKey();
        // 查询商品信息
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(0.00);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getProductId().endsWith(orderDetail.getProductId())) {
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtils.genUniqueKey());
                    orderDetailList.add(orderDetail);
                }
            }
        }

        // 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);
        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        orderDTO.setOrderAccount(orderAmount);
        orderDTO.setOrderStatus(OrderStatus.NEW_ORDER.getCode());
        orderDTO.setPayStatus(PayStatus.UN_PAY.getCode());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        // 先存储订单信息
        orderMasterDao.save(orderMaster);
        // 再存储订单详情信息，可以优化不用循环
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetailDao.save(orderDetail);
        }
        return orderDTO;
    }
}
