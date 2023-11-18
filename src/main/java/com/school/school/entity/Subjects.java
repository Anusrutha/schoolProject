package com.school.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
public class Subjects {
    @Id
   private String subjectCode;
   private String subjectName;
}
