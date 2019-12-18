package com.aaa.springcloud.controller;

import com.aaa.springcloud.model.Book;
import com.aaa.springcloud.service.ISpringcloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private ISpringcloudService springcloudService;

    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return springcloudService.selectAllBooks();
    }

   /* @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Book selectById(@RequestParam("id") Integer id){

        return springcloudService.selectById(id);
    }*/
}
