package com.example.springboot_1;

import com.example.springboot_1.entity.Book;
import com.example.springboot_1.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class Springboot1ApplicationTests {

    @Autowired
    private BookRepository repository;

    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Book> page = repository.findAll(pageRequest);
        int i = 0;
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("张三");
        book.setAuthor("男");
        Book book1 = repository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById() {
        Book book = repository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(26);
        book.setName("11111111");
        Book book1 =repository.save(book);
        System.out.println(book1);
    }

    @Test
    void dalete(){
        repository.deleteById(26);
    }
}
