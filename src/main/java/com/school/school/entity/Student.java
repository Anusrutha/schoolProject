package com.school.school.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity //table
@Setter
@Getter
@ToString
public class Student {
    //fields
    //School
    //school_data
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @Column(length = 50)
    private String studentName;
    private String studentContact;
    private String studentEmail;

    private String gender;

    //Why only private??
    //How to make studentContact as primary?

}


