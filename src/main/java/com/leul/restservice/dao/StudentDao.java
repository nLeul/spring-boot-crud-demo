package com.leul.restservice.dao;

import com.leul.restservice.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    int insertNewStudent(UUID studentId, Student student);
    int updateStudentById(UUID studentId, Student studentUpdate);
    int deleteStudentById(UUID studentId);

    Student selectStudentsById(UUID studentId);
    List<Student> selectAllStudents();
}
