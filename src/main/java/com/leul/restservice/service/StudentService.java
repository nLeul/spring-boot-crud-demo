package com.leul.restservice.service;

import com.leul.restservice.dao.StudentDao;
import com.leul.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student) {
        UUID studentUuid;
        if (studentId == null) {
            studentUuid = UUID.randomUUID();
        } else {
            studentUuid = studentId;
        }
        student.setId(studentUuid);
        // UUID studentUuid=studentId==null?UUID.randomUUID():studentId;
        return studentDao.insertNewStudent(studentUuid, student);
    }

    public Student getStudentsById(UUID studentId) {
        return studentDao.selectStudentsById(studentId);
    }

    public int updateStudentById(UUID studentId, Student updateStudent) {
//        UUID newStudentId = UUID.randomUUID();
        return studentDao.updateStudentById(studentId, updateStudent);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }

}
