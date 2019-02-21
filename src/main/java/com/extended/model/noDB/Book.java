package com.extended.model.noDB;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Book")
public class Book {

    private String name;
}
