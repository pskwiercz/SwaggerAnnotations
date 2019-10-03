package com.pskwierc.swaggerannotations.model;

import com.pskwierc.swaggerannotations.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private BookRepository bookRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void run(ApplicationArguments args) {
        bookRepository.save(new Book("Sam Newman", "Building Microservices", "1491950358"));
        bookRepository.save(new Book("Robert Martin", "Clean Code", "9780132350884"));
        bookRepository.save(new Book("Robert Martin", "Clean Architecture", "0134494164"));

        bookRepository.findAll().forEach(System.out::println);
    }
}
