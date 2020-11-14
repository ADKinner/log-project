package com.mastery.java.task.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Employee {

    @NonNull
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;
}
