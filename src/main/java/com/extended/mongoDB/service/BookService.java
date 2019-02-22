package com.extended.mongoDB.service;

import com.extended.base.profile.MongoProfile;
import com.extended.mongoDB.model.Book;
import com.extended.mongoDB.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@MongoProfile
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }



}
