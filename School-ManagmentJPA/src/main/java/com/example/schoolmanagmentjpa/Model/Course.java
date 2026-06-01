package com.example.schoolmanagmentjpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @Column(nullable = false)
 private String name;

 @ManyToOne
 @JoinColumn(name = "teacher_id")
 @JsonIgnore
 private Teacher teacher;

 @ManyToMany(mappedBy = "courses")
 @JsonIgnore
 //تكون set وجاهزه اول مايكون فيه كورس
 private Set<Student> students = new HashSet<>();
}
