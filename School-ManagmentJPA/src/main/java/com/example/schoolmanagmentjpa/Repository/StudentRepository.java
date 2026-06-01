package com.example.schoolmanagmentjpa.Repository;

import com.example.schoolmanagmentjpa.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);
}