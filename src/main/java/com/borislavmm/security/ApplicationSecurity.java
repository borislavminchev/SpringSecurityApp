package com.borislavmm.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@ComponentScan
public class ApplicationSecurity extends WebSecurityConfigurerAdapter { 

    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Bean
//    BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()                      V fun123 V
//                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//                .withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
//                .withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));

//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);

        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/showLoginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll()//permit everyone to see the login page
                .and()
                    .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }
}
