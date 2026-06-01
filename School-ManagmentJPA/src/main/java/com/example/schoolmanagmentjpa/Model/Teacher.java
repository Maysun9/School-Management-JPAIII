package com.example.schoolmanagmentjpa.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 15)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private Double salary;

    @OneToOne(mappedBy = "teacher",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private Set<Course> courses;
}