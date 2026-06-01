package com.example.schoolmanagmentjpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(25)", nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String major;

    // ManyToMany
    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private Set<Course> courses;
}
