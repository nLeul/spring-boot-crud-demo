package com.leul.restservice.dao;

import com.leul.restservice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final Map<UUID, Student> db;

    public StudentDaoImpl() {
        db = new HashMap<>();
    UUID studentId=UUID.randomUUID();
    db.put(studentId,new Student(studentId,"Leul","Necha","Computer Science"));
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        db.put(studentId, student);
        return 0;
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        db.put(studentId, studentUpdate);
        return 0;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        db.remove(studentId);
        return 0;
    }

    @Override
    public Student selectStudentsById(UUID studentId) {
        return db.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(db.values());
    }
}
