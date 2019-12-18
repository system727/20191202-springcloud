package com.aaa.springcloud.service;

import com.aaa.springcloud.mapper.BookMapper;
import com.aaa.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectAllBooks(){
        return bookMapper.selectAll();
    }

    public Book selectById(Integer id){
        return bookMapper.selectByPrimaryKey(id);

    }
}
