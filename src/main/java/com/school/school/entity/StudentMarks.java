package com.school.school.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class StudentMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private int studentMarksId;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
  // private int studentId;
    @ManyToOne
    @JoinColumn(name = "subject_code" )
    private Subjects subjects;
   //private String subjectCode;
  private   int studentMarks;
}
