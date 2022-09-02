package com.toec.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(indexName = "book")
public class Book {
//    @Id
    private Integer id;
    private String name;
    private String type;
    private String description;
}
