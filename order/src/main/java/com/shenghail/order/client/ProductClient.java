package com.shenghail.order.client;

import com.shenghail.order.dto.CartDTO;
import com.shenghail.order.model.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 使用Feign(伪装的意思, 可以理解成是被调服务的一个替代品,
 * 直接通过这个类定义的方法来调用目标应用的方法)
 */
@Component
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String getMsg();

    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder (@RequestBody List<String> productIdList);

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
