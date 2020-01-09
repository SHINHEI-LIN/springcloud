package com.shenghail.product.service.impl;

import com.shenghail.product.dao.ProductInfoDao;
import com.shenghail.product.dto.CartDTO;
import com.shenghail.product.enums.ProductStatus;
import com.shenghail.product.enums.ResultEnum;
import com.shenghail.product.exception.ProductException;
import com.shenghail.product.model.ProductInfo;
import com.shenghail.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    public List<ProductInfo> findAllProduct() {
        return productInfoDao.findByProductStatus(ProductStatus.UP.getCode());
    }

    public List<ProductInfo> findProductInfoByProductIdIn(List<String> productIdList) {
        return productInfoDao.findProductInfoByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productOptional = productInfoDao.findById(cartDTO.getProductId());
            // 判断商品是否存在
            if (!productOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            // 判断商品库存是否足够
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }
}