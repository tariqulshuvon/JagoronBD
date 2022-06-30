package com.therapJavaFest.jagoronBD.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationForm {
    private Long id;
    private String username;
    private String password;
}
