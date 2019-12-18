package com.aaa.springcloud.factory;

import com.aaa.springcloud.model.Book;
import com.aaa.springcloud.service.ISpringcloudService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ISpringcloudFallBackFactory implements FallbackFactory<ISpringcloudService> {

    @Override
    public ISpringcloudService create(Throwable throwable) {

        ISpringcloudService springcloudService = new ISpringcloudService() {
            @Override
            public List<Book> selectAllBooks() {
                System.out.println("我被熔断了");
                return null;
            }

           /* @Override
            public Book selectById(Integer id) {
                return null;
            }*/
        };
        return springcloudService;
    }
}
