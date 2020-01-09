package com.shenghail.product.controller;

import com.shenghail.product.dto.CartDTO;
import com.shenghail.product.model.ProductInfo;
import com.shenghail.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServerController {

    @Autowired
    private ProductService productService;

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
}
