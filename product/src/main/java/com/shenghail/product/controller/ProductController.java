package com.shenghail.product.controller;

import com.shenghail.product.dao.ProductCategoryDao;
import com.shenghail.product.model.ProductCategory;
import com.shenghail.product.model.ProductInfo;
import com.shenghail.product.service.ProductService;
import com.shenghail.product.vo.ProductInfoVo;
import com.shenghail.product.vo.ProductVO;
import com.shenghail.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @PostMapping("/list")
    @ResponseBody
    public ResultVO<ProductVO> list() {
//      1.查询所有在架商品
        List<ProductInfo> allProduct = productService.findAllProduct();
//      2.获取类目列表
        List<Integer> categoryTypeList = allProduct.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
//      3.查询类目
        List<ProductCategory> categoryList = productCategoryDao.findByCategoryTypeIn(categoryTypeList);
//      4.构造数据
        List<ProductVO> productVOList = new LinkedList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new LinkedList<>();
            for (ProductInfo productInfo : allProduct) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVOList);

        return resultVO;
    }
}
