package com.example.schoolmanagmentjpa.Service;


import com.example.schoolmanagmentjpa.API.ApiException;
import com.example.schoolmanagmentjpa.DTO.IN.StudentDTO;
import com.example.schoolmanagmentjpa.DTO.OUT.CourseDTOOUT;
import com.example.schoolmanagmentjpa.DTO.OUT.StudentDTOOUT;
import com.example.schoolmanagmentjpa.Model.Course;
import com.example.schoolmanagmentjpa.Model.Student;
import com.example.schoolmanagmentjpa.Repository.CourseRepository;
import com.example.schoolmanagmentjpa.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // add new student
    public void addStudent(Student student) {
        studentRepository.save(student);
    }


    // update student
    public void updateStudent(Integer id, StudentDTO dto) {
        Student old = studentRepository.findStudentById(id);
        if (old == null) {
            throw new ApiException("Student not found");
        }
        old.setName(dto.getName());
        old.setAge(dto.getAge());
        old.setMajor(dto.getMajor());
        studentRepository.save(old);
    }

    // delete student
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student);
    }

    //assign
    public void assignStudentToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }

        course.getStudents().add(student);
        student.getCourses().add(course);


        courseRepository.save(course);
    }

    // endpoint takes studentId and major
    public void changeMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        student.setMajor(major);

        for (Course course : student.getCourses()) {
            course.getStudents().remove(student);
            courseRepository.save(course);
        }
        // drop all courses when major changes
        student.getCourses().clear();
        studentRepository.save(student);
    }


    //get
    //public List<StudentDTOOUT> getStudents() {
//    List<Student> students = studentRepository.findAll();
//    List<StudentDTOOUT> result = new ArrayList<>();
//    for (Student student : students) {
//        List<CourseDTOOUT> courses = new ArrayList<>();
//        if (student.getCourses() != null) {
//            for (Course course : student.getCourses()) {
//                courses.add(new CourseDTOOUT(course.getId(), course.getName()));
//            }
//        }
//        result.add(new StudentDTOOUT(student.getId(), student.getName(),
//                student.getAge(), student.getMajor(), courses));
//    }
//    return result;
//}

    // DTO method
//    public StudentDTOOUT convertToDTO(Student student) {
//        List<CourseDTOOUT> courses = new ArrayList<>();
//        if (student.getCourses() != null) {
//            for (Course course : student.getCourses()) {
//                courses.add(new CourseDTOOUT(course.getId(), course.getName()));
//            }
//        }
//        return new StudentDTOOUT(student.getId(), student.getName(), student.getAge(), student.getMajor(), courses);
//    }
}
