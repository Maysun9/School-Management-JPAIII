package com.example.schoolmanagmentjpa.Controller;


import com.example.schoolmanagmentjpa.API.ApiResponse;
import com.example.schoolmanagmentjpa.DTO.IN.CourseDTO;
import com.example.schoolmanagmentjpa.Model.Course;
import com.example.schoolmanagmentjpa.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody @Valid CourseDTO dto){
        courseService.updateCourse(id,dto);
        return ResponseEntity.status(200).body(new ApiResponse("course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted"));
    }

    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity<ApiResponse> assignCourseToTeacher(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        courseService.assignCourseToTeacher(courseId, teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Course assigned to teacher successfully"));
    }

    @GetMapping("/teacher-name/{courseId}")
    public ResponseEntity<ApiResponse> getTeacherName(@PathVariable Integer courseId){
        String teacherName = courseService.getTeacherName(courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher name=  " + teacherName));
    }

    @GetMapping("/students/{courseId}")
    public ResponseEntity<?> getStudentList(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getStudentList(courseId));
    }
}