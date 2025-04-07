package com.ncy.services.order.feign;

import com.ncy.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "service-product")
public interface ProductFeignClient {
    @GetMapping("api/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
