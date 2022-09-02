package com.toec.domain;

import lombok.Data;

@Data
public class BookFilter {
    private int page;
    private int pageSize;
    private String name;
    private String type;
    private String description;

}
