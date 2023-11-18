package com.school.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Setter
@Getter
public class Login {

    private String userName;
    private String password;
    @Id
    private String email;
}
