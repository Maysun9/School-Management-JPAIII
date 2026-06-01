package com.example.schoolmanagmentjpa.DTO.IN;

import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3,max = 15,message = "name length must be between 3 and 15")
    private String name;

    @NotNull(message = "age cannot be null")
    @Min(value = 22,message = "minimum age is 22")
    @Max(value = 65,message = "maximum age is 65")
    private Integer age;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "invalid email")
    private String email;

    @NotNull(message = "salary cannot be null")
    @Positive(message = "salary must be positive")
    private Double salary;
}
