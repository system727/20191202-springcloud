package com.aaa.springcloud.service;

import com.aaa.springcloud.factory.ISpringcloudFallBackFactory;
import com.aaa.springcloud.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "book-provider", fallbackFactory = ISpringcloudFallBackFactory.class)
public interface ISpringcloudService {
    @GetMapping("/all")
    List<Book> selectAllBooks();

    /*@GetMapping ("/selectById")
    Book selectById(@RequestParam("id") Integer id);
*/

}
