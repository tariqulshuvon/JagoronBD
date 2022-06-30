package com.therapJavaFest.jagoronBD.form;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PoliceNumberForm {

    private Long id;

    private Long divisionId;

    private String name;

    private String phoneNumber;

    private String phoneNumberNo;

}
