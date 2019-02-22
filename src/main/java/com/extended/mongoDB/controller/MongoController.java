package com.extended.mongoDB.controller;


import com.extended.base.profile.MongoProfile;
import com.extended.mongoDB.model.Book;
import com.extended.mongoDB.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@MongoProfile
@RestController
@RequestMapping("extended")
public class MongoController {

    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public ResponseEntity index(){
        return ResponseEntity.ok("Ok !!");
    }

    @GetMapping("/book/all")
    public ResponseEntity getAllBook(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping("/book/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        try {
            bookService.save(book);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok(bookService.getAllBooks());
    }



}
