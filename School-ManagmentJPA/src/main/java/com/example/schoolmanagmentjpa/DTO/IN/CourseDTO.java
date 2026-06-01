package com.example.schoolmanagmentjpa.DTO.IN;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 15, message = "Name length should be between 3 and 15 characters")
    private String name;
}