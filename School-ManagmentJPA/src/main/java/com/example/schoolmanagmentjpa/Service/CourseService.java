package com.example.schoolmanagmentjpa.Service;

import com.example.schoolmanagmentjpa.API.ApiException;
import com.example.schoolmanagmentjpa.DTO.IN.CourseDTO;
import com.example.schoolmanagmentjpa.Model.Course;
import com.example.schoolmanagmentjpa.Model.Student;
import com.example.schoolmanagmentjpa.Model.Teacher;
import com.example.schoolmanagmentjpa.Repository.CourseRepository;
import com.example.schoolmanagmentjpa.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    // get
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // add

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    //update
    public void updateCourse(Integer id, CourseDTO dto) {
        Course old = courseRepository.findCourseById(id);
        if (old == null) {
            throw new ApiException("Course not found");
        }
        old.setName(dto.getName());
        courseRepository.save(old);
    }

    //delete
    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }

    //assign
    public void assignCourseToTeacher(Integer courseId, Integer teacherId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    // endpoint takes courseId and returns teacher name
    public String getTeacherName(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if(course == null){
            throw new ApiException("Course not found");
        }
        //NullPointerException
        if(course.getTeacher() == null){
            throw new ApiException("No teacher assigned to this course");
        }
        return course.getTeacher().getName();
    }

    // endpoint takes courseId and returns student list
    public Set<Student> getStudentList(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        return course.getStudents();
    }

    //DTO Method
 // public CourseDTOOUT convertToDTO(Course course) {
//        return new CourseDTOOUT(course.getId(), course.getName());
//    }
}