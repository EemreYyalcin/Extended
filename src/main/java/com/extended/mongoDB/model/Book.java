package com.extended.mongoDB.model;


import com.extended.base.profile.MongoProfile;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@MongoProfile
@Data
@Accessors(chain = true)
@Document
public class Book {

    @Id
    private String name;

    private String author;

}
