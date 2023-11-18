package com.school.school.repository;

import com.school.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    //select * from school.student where student_name="Anu";


    List<Student> findByStudentName(String studentName);  //named Query
//   Optional<List<Student>> findByStudentName(String studentName);

    // select * from Student where student_id between 3 and 6 order by desc
    Optional<List<Student>> findByStudentIdBetweenOrderByStudentIdDesc(Integer value1, Integer value2);


    @Query(value = "select * from student", nativeQuery = true)
    Optional<List<Student>> myownQueryMethod(); //nativeQuery

    @Query(value = "select u from Student u")
    Optional<List<Student>> jpaQueryMethod(); // jpaQuery
    @Query(value ="select u from Student u where u.studentName = :name")
   Optional<List<Student>> jpaQueryMethodWithParam(@Param("name") String name); //// jpaQuery


}

