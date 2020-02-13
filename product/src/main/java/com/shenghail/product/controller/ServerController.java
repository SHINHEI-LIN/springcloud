package com.shenghail.product.controller;

import com.shenghail.product.dto.CartDTO;
import com.shenghail.product.model.ProductInfo;
import com.shenghail.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 只有配置了该注解的地方才能使用到配置中心刷新的配置
@RefreshScope
public class ServerController {

    @Autowired
    private ProductService productService;

    @Value("${env}")
    private String env;

    @GetMapping("/msg")
    public String msg() {
        return "this is product msg 2";
    }

    /**
     * 查询商品列表(给订单服务用)
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder (@RequestBody List<String> productIdList) {
        return productService.findProductInfoByProductIdIn(productIdList);
    }

    /**
     * 商品减库存
     * @param cartDTOList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }

    @GetMapping("/env")
    public String getEnv() {
        return env;
    }
}
