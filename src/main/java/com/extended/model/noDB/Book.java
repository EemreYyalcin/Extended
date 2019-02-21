package com.extended.model.noDB;


import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Profile("mongo")
@Document
public class Book {

    @Id
    private String name;

    private String author;

}
