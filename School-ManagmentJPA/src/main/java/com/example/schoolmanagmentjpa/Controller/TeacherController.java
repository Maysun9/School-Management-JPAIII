package com.example.schoolmanagmentjpa.Controller;

import com.example.schoolmanagmentjpa.API.ApiResponse;
import com.example.schoolmanagmentjpa.DTO.IN.TeacherDTO;
import com.example.schoolmanagmentjpa.Model.Teacher;
import com.example.schoolmanagmentjpa.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid TeacherDTO teacherDTO){
        teacherService.updateTeacher(id,teacherDTO);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted"));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}