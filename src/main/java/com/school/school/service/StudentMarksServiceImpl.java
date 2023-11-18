package com.school.school.service;

import com.school.school.dto.StudentMarksDTO;
import com.school.school.entity.Student;
import com.school.school.entity.StudentMarks;
import com.school.school.entity.Subjects;
import com.school.school.exception.StudentException;
import com.school.school.repository.StudentMarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentMarksServiceImpl implements StudentMarksInterface {

    /*
    @Description: We are adding the student marks to the studentMarksTable
     */
    @Autowired
    StudentMarksRepo studentMarksRepo;
    @Override
    public StudentMarks addMarks(StudentMarksDTO studentMarksDTO) {


//        if(Validations.marksValidation(studentMarksDTO.getStudentMarks())){
        if(marksValidation(studentMarksDTO.getStudentMarks())){
            throw new StudentException("marks should be not more than 100 and not less than 0");
        }

        Student student=new Student();
        student.setStudentId(studentMarksDTO.getStudentId());


        Subjects subjects=new Subjects();
        subjects.setSubjectCode(studentMarksDTO.getSubjectCode());


        StudentMarks studentMarks=new StudentMarks();
        studentMarks.setStudentMarks(studentMarksDTO.getStudentMarks());
        studentMarks.setStudent(student); // foregn key
        studentMarks.setSubjects(subjects); // foregn key


        return studentMarksRepo.save(studentMarks);



    }
//Create a API for get all marks
    //Convert Entity to DTO
    @Override
    public Optional<List<StudentMarksDTO>> getMarks() {
        List<StudentMarksDTO> studentMarksDTOList=new ArrayList<>();

      List<StudentMarks> studentMarksList = studentMarksRepo.findAll();

      //Need to copy data from studentMarksList to studentMarksDTOList
        /*
        iterate the studentMarksList get the each studentmarks object


         */

        System.out.println(List.of(studentMarksList));

        for (int i=0; i<studentMarksList.size();i++){
            System.out.println(studentMarksList.get(i));
            StudentMarks studentMarks =studentMarksList.get(i);

            StudentMarksDTO studentMarksDto =
                    StudentMarksDTO.builder()//obg creation
                    .studentId(studentMarks.getStudent().getStudentId())
                    .studentMarks(studentMarks.getStudentMarks())
                    .studentMarksId(studentMarks.getStudentMarksId())
                    .subjectCode(studentMarks.getSubjects().getSubjectCode())
                    .build();

            studentMarksDTOList.add(studentMarksDto);

        }


System.out.println("kkkkkk");
System.out.println("llll");

        return  Optional.of(studentMarksDTOList);
    }

    @Override
    public Optional<StudentMarks> getMarksById(int id) {
        Optional<StudentMarks> studentMarks=studentMarksRepo.findById(id);
        return studentMarks;
    }

    private static boolean marksValidation(int marks){
        if(marks>100 || marks<0){
            return false;
        }
        return true;
    }
}
