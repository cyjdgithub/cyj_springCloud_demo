package com.ncy.services.product.service.impl;

import com.ncy.product.bean.Product;
import com.ncy.services.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.LICENSE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public Product getProductByid(Long productId) {
        Product product = new Product();
        product.setId(productId)
                .setPrice(new BigDecimal("99"))
                .setProductName("apple"+productId)
                .setNum(2);

        return product;
    }


}
