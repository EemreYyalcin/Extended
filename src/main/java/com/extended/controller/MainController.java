package com.extended.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("extended")
public class MainController {

    @GetMapping("/index")
    public ResponseEntity index(){
        return ResponseEntity.ok("Ok !!");
    }



}
