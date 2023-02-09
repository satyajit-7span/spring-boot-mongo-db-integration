package com.example.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequestDto {

    @NotEmpty(message = "Student name should not be empty")
    @NotBlank(message = "Student name should not be blank")
    @NotNull(message = "Student name should not be null")
    private String name;

    @NotEmpty(message = "Student email should not be empty")
    @NotBlank(message = "Student email should not be blank")
    @NotNull(message = "Student email should not be null")
    private String email;
}
