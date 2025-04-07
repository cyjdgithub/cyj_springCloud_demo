package com.ncy.services.order.service.impl;

import com.ncy.order.bean.Order;
import com.ncy.product.bean.Product;
import com.ncy.services.order.feign.ProductFeignClient;
import com.ncy.services.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    ProductFeignClient productFeignClient;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product product = productFeignClient.getProductById(productId);
        Order order = new Order();
        order.setOrderId(1L);

        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("xiaoming");
        order.setAddress("leiden");

        order.setProductList(Arrays.asList(product));
        return order;

    }

    private Product getProductFromRemoteWithLoadBalancerAnnotation(Long productId){
        //ServiceInstance choose = loadBalancerClient.choose("service-product");

        String url = "http://service-product/product/"+productId;

        log.info("url:{}",url);

        Product product = restTemplate.getForObject(url,Product.class);
        return product;

    }

    private Product getProductFromRemoteWithLoadBalancer(Long productId){
        ServiceInstance choose = loadBalancerClient.choose("service-product");

        String url = "http://" + choose.getHost()+":"+choose.getPort()+"/product/"+productId;

        log.info("url:{}",url);

        Product product = restTemplate.getForObject(url,Product.class);
        return product;

    }

    private Product getProductFromRemote(Long productId){
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);

        String url = "http://" + instance.getHost()+":"+instance.getPort()+"/product/"+productId;

        log.info("url:{}",url);

        Product product = restTemplate.getForObject(url,Product.class);
        return product;

    }
}
