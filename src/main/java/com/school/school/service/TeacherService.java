package com.school.school.service;

import com.school.school.entity.Student;
import com.school.school.entity.Teacher;
import com.school.school.exception.StudentException;
import com.school.school.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService implements TeacherInterface{
    @Autowired
    TeacherRepo teacherRepo;
    @Override
    public Teacher addTeacher(Teacher teacher) {

        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        Teacher updatedTeacher= teacherRepo.save(teacher);

        return updatedTeacher;
    }

    @Override
    public String deleteTeacherByID(int id) {

         teacherRepo.deleteById(id);

        return "Teacher record deleted Successfully";
    }

    @Override
    public Teacher readTeacherByID(int id) {
      Optional<Teacher>  readTeacher= teacherRepo.findById(id);
      if (readTeacher.isPresent()){
        /*  Optional<Teacher> readTeacher1 = teacherRepo.findById(id);*/
          return readTeacher.get();
      }
      else {
          throw new StudentException("Teacher not found");
      }



       /* Optional<Teacher> readTeacher = teacherRepo.findById(id);
        if (readTeacher.isPresent()) {
            return readTeacher.get();
        } else {
            throw new ArithmeticException("wrong id passed");
        }
*/
    }
}
