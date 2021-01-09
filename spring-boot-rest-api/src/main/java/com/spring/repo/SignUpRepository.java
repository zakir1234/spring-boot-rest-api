package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.SignUp;


public interface SignUpRepository extends JpaRepository<SignUp, Long>{

SignUp findByUserName(String userName);

}
