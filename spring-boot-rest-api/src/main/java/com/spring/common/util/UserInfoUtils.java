/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.common.util;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import com.spring.entity.User;


/**
 *
 * @author Users
 */
@Component
public class UserInfoUtils {

    private static ApplicationContext context;
  
    @Autowired
    public UserInfoUtils(ApplicationContext ac) {
        context = ac;
    }

    public static ApplicationContext getContext() {
        return context;
    }
    
    
    public static User getLoggedInUserObject() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;

    }
    
    public static List<String> getLoggedInUserRoles() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getRoles();
    }
    
//    public static String getCurrentHospitalId() {
//    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    	return String.valueOf(user.getHospitalId());
//    }

	/*
	 * public static String getLoggedInUserInstitute() {
	 * 
	 * Users user = (Users)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); return
	 * user.getInstituteId();
	 * 
	 * }
	 */

	public static String getOnlineHealthCareClientId() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		try {
			OAuth2Authentication requestingUser = (OAuth2Authentication) securityContext.getAuthentication();
			String clientId = requestingUser.getOAuth2Request().getClientId();
			return clientId;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
    
    public static String getLoggedInUser() {
     
    	try{
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();    
        return user.getUsername();
        }catch(Exception e){
            return getOnlineHealthCareClientId();
        }
    }
    
	/*
	 * public static String getCustomStaffId() { Users user = (Users)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * if(user.getStaffBasic()!=null){ return
	 * user.getStaffBasic().getCustomStaffId(); } return ""; }
	 * 
	 * public static String getStaffImageName() { Users user = (Users)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * if(user.getStaffBasic()!=null){ return user.getStaffBasic().getImageName(); }
	 * return ""; }
	 * 
	 * public static String getLoggedInUserType() { Users user = (Users)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); return
	 * user.getUserType(); }
	 */

    public static String getHashPassword(String password) {
        PasswordEncoder userPasswordEncoder = context.getBean("userPasswordEncoder", PasswordEncoder.class);
        return userPasswordEncoder.encode(password);
    }
    
    public static boolean isPreviousPasswordCorrect(String previousPlainPassword,String previousEncriptedPassword) {
        PasswordEncoder userPasswordEncoder = context.getBean("userPasswordEncoder", PasswordEncoder.class);
       return userPasswordEncoder.matches(previousPlainPassword, previousEncriptedPassword);
    }
    
	/*
	 * public static String getLoggedInInstituteAcaYear(){ Users user = (Users)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); return
	 * user.getAcademicYear(); }
	 */

    public static String getLoggedInNickName(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getNickName();
    }


}
