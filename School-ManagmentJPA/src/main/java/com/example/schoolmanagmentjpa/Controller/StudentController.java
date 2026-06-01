package com.example.schoolmanagmentjpa.Controller;


import com.example.schoolmanagmentjpa.API.ApiResponse;
import com.example.schoolmanagmentjpa.DTO.IN.StudentDTO;
import com.example.schoolmanagmentjpa.Model.Student;
import com.example.schoolmanagmentjpa.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody @Valid StudentDTO dto) {
        studentService.updateStudent(id, dto);
        return ResponseEntity.status(200).body(new ApiResponse("student updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted"));
    }

    @PutMapping("/assign/{studentId}/{courseId}")
    public ResponseEntity<?> assignStudentToCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.assignStudentToCourse(studentId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Student registered in course successfully"));
    }

    @PutMapping("/change-major/{studentId}/{major}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer studentId, @PathVariable String major) {
        studentService.changeMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("major changed and courses dropped"));
    }
}