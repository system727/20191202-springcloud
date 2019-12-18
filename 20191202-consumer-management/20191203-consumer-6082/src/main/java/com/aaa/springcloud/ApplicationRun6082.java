package com.aaa.springcloud;

import com.aaa.ribbon.RibbonRuleMine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/2 14:57
 * @Description
 **/
@SpringBootApplication
@EnableDiscoveryClient
/*@RibbonClient(name = "BOOK-PROVIDER", configuration = RibbonRuleMine.class)*/
public class ApplicationRun6082 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6082.class, args);
    }

}
