package com.example.schoolmanagmentjpa.Service;

import com.example.schoolmanagmentjpa.API.ApiException;
import com.example.schoolmanagmentjpa.DTO.IN.TeacherDTO;
import com.example.schoolmanagmentjpa.DTO.OUT.AddressDTOOUT;
import com.example.schoolmanagmentjpa.DTO.OUT.CourseDTOOUT;
import com.example.schoolmanagmentjpa.DTO.OUT.TeacherDTOOUT;
import com.example.schoolmanagmentjpa.Model.Course;
import com.example.schoolmanagmentjpa.Model.Teacher;
import com.example.schoolmanagmentjpa.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    // get
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    //add
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    //update
    public void updateTeacher(Integer id, TeacherDTO teacherDTO){
        Teacher old = teacherRepository.findTeacherById(id);
        if(old == null){
            throw new ApiException("Teacher not found");
        }

        old.setName(teacherDTO.getName());
        old.setAge(teacherDTO.getAge());
        old.setEmail(teacherDTO.getEmail());
        old.setSalary(teacherDTO.getSalary());

        teacherRepository.save(old);
    }

    //delete
    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    //get Teacher details
    public Teacher getTeacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }





//get with mapping
 //    public List<TeacherDTOOUT> getTeachers() {
//        List<Teacher> teachers = teacherRepository.findAll();
//        List<TeacherDTOOUT> result = new ArrayList<>();
//        for (Teacher teacher : teachers) {
//            // build courses list
//            List<CourseDTOOUT> courses = new ArrayList<>();
//            if (teacher.getCourses() != null) {
//                for (Course course : teacher.getCourses()) {
//                    courses.add(new CourseDTOOUT(course.getId(), course.getName()));
//                }
//            }
//            AddressDTOOUT addressDTOOUT = null;
//            if (teacher.getAddress() != null) {
//                addressDTOOUT = new AddressDTOOUT(teacher.getAddress().getId(), teacher.getAddress().getArea(), teacher.getAddress().getStreet(), teacher.getAddress().getBuildingNumber());
//            }
//            result.add(new TeacherDTOOUT(teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getEmail(), teacher.getSalary(), addressDTOOUT, courses));
//        }
//        return result;
//    }
//add dto
    //    public void addTeacher(TeacherDTO dto) {
//        Teacher teachers = new Teacher();
//        teachers.setName(dto.getName());
//        teachers.setAge(dto.getAge());
//        teachers.setEmail(dto.getEmail());
//        teachers.setSalary(dto.getSalary());
//        teacherRepository.save(teachers);
//    }
    //DTO method
//    public TeacherDTOOUT convertToDTO(Teacher teacher){
//        List<CourseDTOOUT> courses = new ArrayList<>();
//        if(teacher.getCourses() != null){
//            for(Course course : teacher.getCourses()){
//                courses.add(new CourseDTOOUT(course.getId(), course.getName()));
//            }
//        }
//
//        AddressDTOOUT addressDTOOUT = null;
//        if(teacher.getAddress() != null){
//            addressDTOOUT = new AddressDTOOUT(teacher.getAddress().getId(), teacher.getAddress().getArea(), teacher.getAddress().getStreet(), teacher.getAddress().getBuildingNumber());
//        }
//
//        return new TeacherDTOOUT(teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getEmail(), teacher.getSalary(), addressDTOOUT, courses);
//    }
//    public TeacherDTOOUT getTeacherDetails(Integer id) {
//        Teacher teacher = teacherRepository.findTeacherById(id);
//        if (teacher == null) {
//            throw new ApiException("Teacher not found");
//        }
//        List<CourseDTOOUT> courses = new ArrayList<>();
//        if (teacher.getCourses() != null) {
//            for (Course course : teacher.getCourses()) {
//                courses.add(new CourseDTOOUT(course.getId(), course.getName()));
//            }
//        }
//        AddressDTOOUT addressDTOOUT = null;
//        if (teacher.getAddress() != null) {
//            addressDTOOUT = new AddressDTOOUT(
//                    teacher.getAddress().getId(),
//                    teacher.getAddress().getArea(),
//                    teacher.getAddress().getStreet(),
//                    teacher.getAddress().getBuildingNumber()
//            );
//        }
//        return new TeacherDTOOUT(teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getEmail(), teacher.getSalary(), addressDTOOUT, courses);
//    }
}