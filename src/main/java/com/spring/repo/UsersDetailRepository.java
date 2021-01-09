package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.entity.UsersDetails;


public interface UsersDetailRepository extends JpaRepository<UsersDetails, Long>{

	UsersDetails findByUsername(String username);


}
