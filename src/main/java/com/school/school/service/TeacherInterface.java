package com.school.school.service;

import com.school.school.entity.Teacher;

public interface TeacherInterface {
     Teacher addTeacher(Teacher teacher);
     Teacher updateTeacher(Teacher teacher);
     String deleteTeacherByID(int id);
     Teacher readTeacherByID(int id);
}
