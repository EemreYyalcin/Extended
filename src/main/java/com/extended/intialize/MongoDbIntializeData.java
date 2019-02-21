package com.extended.intialize;


import com.extended.model.noDB.Book;
import com.extended.repo.noDB.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mongo")
public class MongoDbIntializeData implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
//        bookRepository.save(new Book().setName("TestBook").setAuthor("TestAuthor"));
    }
}
