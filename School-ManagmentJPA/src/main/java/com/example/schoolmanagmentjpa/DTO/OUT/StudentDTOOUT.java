package com.example.schoolmanagmentjpa.DTO.OUT;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTOOUT {

    private Integer id;
    private String name;
    private Integer age;
    private String major;
    private List<CourseDTOOUT> courses;
}