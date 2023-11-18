package com.school.school.repository;

import com.school.school.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    //select * from Login where user_name="" and password= ""

    Optional<Login> findByUserNameAndPassword(String userName, String password);


}
