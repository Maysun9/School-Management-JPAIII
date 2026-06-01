package com.example.schoolmanagmentjpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @Column( nullable = false, columnDefinition = "varchar(50)")
    private String area;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String street;

    @Column(nullable = false)
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;
}