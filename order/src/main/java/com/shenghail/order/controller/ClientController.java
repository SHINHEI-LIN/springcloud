package com.shenghail.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
    /**
     * 应用间通信主要由两种方式：HTTP && RPC
     * 分别对应Spring Cloud和Dubbo
     * Spring cloud中的RestTemplate对应HTTP通信方式；
     * Dubbo是一个RPC框架，对应着RPC通信
     *
     * 服务的发现有两种, 一种是服务端发现,一种是客户端发现,在springcloud中使用的eureka数据客户端发现,
     * 客户端会向注册中心拉取已注册的服务, 根据负载均衡策略命中某台服务器, 直接发送请求, 这个过程
     * 不需要服务器的参与.
     * Eureka 的客户端负载均衡器是Ribbon, 在RestTemplate/Feign/Zuul中都使用了Ribbon
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 使用RestTemplate进行应用间通信
     * @return
     */
    @GetMapping("/rest/getProductMsg")
    public String getMsgWithRest() {
//      在Spring Cloud中可以使用RestTemplate作为应用间通信的组件，有三种方法实现
//      1.直接使用RestTemplate来调用, url写死
//        RestTemplate restTemplate = new RestTemplate();
//        String ret = restTemplate.getForObject("http://localhost:9002/msg", String.class);
//      2.使用LoadBalancerClient通过应用名获取url, 再使用RestTemplate调用
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance product = loadBalancerClient.choose("product");
//        String url = String.format("http://%s:%s", product.getUri(), product.getPort()) + "/msg";
//        String ret = restTemplate.getForObject(url, String.class);
//      3.将RestTemplate配置成一个Bean注入到容器中, 添加@LoadBalance注解,可以使用应用名替代uri直接调用
        String ret = restTemplate.getForObject("http://product/msg", String.class);
        System.out.println(ret);
        return ret;
    }
}
