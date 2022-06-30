package com.therapJavaFest.jagoronBD.form;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemForm {

    private Long id;

    private Long categoryId;

    private String logo;

    private String image;

    private String name;

    private String description;

    private String link;

}
