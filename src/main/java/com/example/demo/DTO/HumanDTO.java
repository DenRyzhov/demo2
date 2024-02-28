package com.example.demo.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HumanDTO {
    String name;
    String telephoneNumber;
    String email;


}
