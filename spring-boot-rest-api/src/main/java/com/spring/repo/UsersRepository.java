/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.User;


public interface UsersRepository extends JpaRepository<User, Long> {

	public User findByUsernameAndPasswordAndEnabled(String username, String password, boolean enabled);

	public User findByUsername(String username);

	public User findByUsernameAndEnabled(String username, boolean enabled);
	
}
