package com.school.school.repository;

import com.school.school.entity.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentMarksRepo extends JpaRepository<StudentMarks,Integer> {


}
