package com.leul.restservice.resource;


import com.leul.restservice.model.Student;
import com.leul.restservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {
    private StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postStudent(@RequestBody Student student) {
        studentService.persistNewStudent(UUID.randomUUID(), student);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") UUID studentId) {
        return studentService.getStudentsById(studentId);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{studentId}")
    public int updateStudentById(@PathVariable("studentId") UUID studentId, @RequestBody Student studentUpdate) {
        studentUpdate.setId(studentId);
        return studentService.updateStudentById(studentId, studentUpdate);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{studentId}")
    public int deleteStudentById(@PathVariable("studentId") UUID studentId) {
        return studentService.deleteStudentById(studentId);
    }
}
