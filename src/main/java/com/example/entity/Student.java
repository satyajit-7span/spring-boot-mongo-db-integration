package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "students")
@Getter
@Setter
@ToString
public class Student {

    @Id
    private String id;

    private String name;

    private String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
