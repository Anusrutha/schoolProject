package com.school.school.service;


import com.school.school.dto.StudentMarksDTO;
import com.school.school.entity.StudentMarks;

import java.util.List;
import java.util.Optional;

public interface StudentMarksInterface {

    StudentMarks addMarks(StudentMarksDTO studentMarksDTO);
    Optional<List<StudentMarksDTO>> getMarks();

    Optional <StudentMarks> getMarksById(int id);
}
