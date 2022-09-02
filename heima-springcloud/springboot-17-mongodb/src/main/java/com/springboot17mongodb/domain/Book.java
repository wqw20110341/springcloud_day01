package com.springboot17mongodb.domain;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
