package com.example.schoolmanagmentjpa.DTO.IN;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "age cannot be null")
    @Min(value = 15, message = "minimum age is 15")
    private Integer age;

    @NotEmpty(message = "major cannot be empty")
    private String major;
}