/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spring.config.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 *
 * @author zakir
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "spring-boot-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/**";
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	
    	http.
    		headers().
    			frameOptions().
    				disable();
    	
        http
                .csrf().disable()
                .sessionManagement().disable()
                .authorizeRequests()
            //    .antMatchers("/**")
                
                .antMatchers("/","/public/**",
                		"/swagger**",
                		"/v2/api-docs",
                		"/webjars/springfox-swagger-ui/**",
                		"/swagger-resources/**",                   		
                		"/h2/**",      
                		"/images/**")
                
                
                .permitAll().and()
                .requestMatchers()                
                .antMatchers(SECURED_PATTERN).and().authorizeRequests()
                .antMatchers(HttpMethod.POST, SECURED_PATTERN)
                .access(SECURED_WRITE_SCOPE)
                .anyRequest().access(SECURED_READ_SCOPE);
    }
}
