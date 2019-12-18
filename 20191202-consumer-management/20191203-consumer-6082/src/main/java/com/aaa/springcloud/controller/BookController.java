package com.aaa.springcloud.controller;

import com.aaa.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 14:58
 * @Description
 **/
@RestController
public class BookController {

    //private static final String PROVIDER_URL = "http://localhost:8081/all";
    private static final String PROVIDER_URL = "http://BOOK-PROVIDER/all";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    /**
     * @author Seven Lee
     * @description
     *      查询所有的图书信息
     * @param []
     * @date 2019/12/2
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws 
    **/
    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return restTemplate.getForObject(PROVIDER_URL, List.class);
    }

    @GetMapping("/allLB")
    public List<Book> selectAllBooksLb() {

        // 如果需要实现负载均衡，就必须要知道所有provider的ip和端口号
        // 1.获取所有provider的IP地址和端口号(通过ribbon来进行获取)
        // 通过spring.application.name的值进行选择
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-provider");
        // 2.获取host信息
        String host = serviceInstance.getHost();
        // 3.获取port信息
        int port = serviceInstance.getPort();
        System.out.println(port);
        // 4.使用restTemplate进行远程调用
        return restTemplate.getForObject("http://"+host+":"+port+"/all", List.class);
    }


}
