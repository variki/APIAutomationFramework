package com.pjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
@AllArgsConstructor
public class Employee {

    private int id;
    private String firstname;
    private String lastname;

    private Employee(){}
}
