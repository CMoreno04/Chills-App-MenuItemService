package com.chillsapp.menuitemservice.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "menu_item")
public class MenuItem implements Serializable {

    @Id
    private String id; // Changed to String for MongoDB's ObjectId

    private double price;

    private String description;

    private String name;

    private String category;

    private byte[] imageBlob; // You might want to handle large objects differently in MongoDB

}
