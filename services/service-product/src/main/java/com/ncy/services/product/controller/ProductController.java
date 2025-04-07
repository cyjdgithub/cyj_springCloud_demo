package com.ncy.services.product.controller;



import com.ncy.product.bean.Product;
import com.ncy.services.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        System.out.println("hello");
        Product product = productService.getProductByid(productId);
        return product;

    }
}
