/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spring.config.authentication;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.spring.entity.User;
import com.spring.entity.UserRole;
import com.spring.repo.UsersRepository;
import com.spring.repo.UsersRoleRepository;

/**
 *
 * @author zakir
 */

@Service
public class AuthorizationUserDetailsService implements UserDetailsService{
    
    @Autowired
    public UsersRepository usersRepository;
    
    @Autowired
    public UsersRoleRepository userRolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = usersRepository.findByUsername(username);
        if (user != null) {
                List<String> roles = new ArrayList<>(); 
                List<UserRole> userRoles = userRolesRepository.findByUser_Username(user.getUsername());
                userRoles.stream().forEach((ur) -> {
                roles.add(ur.getRole().getRoleName());
            });
                user.setRoles(roles);
                return user;

            } else {
                throw new RuntimeException("user not found");
            }
        } 
    }
    
    

