package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/signin").permitAll()
                .requestMatchers("/public/**").hasRole("NORMAL")
                .requestMatchers("/users/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                //.httpBasic();
                .formLogin();
//                .loginPage("/signin")
//                .loginProcessingUrl("/doLogin")
//                .defaultSuccessUrl("/users/");

        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        //no passwordEncoder
//        UserDetails normalUser= User.withDefaultPasswordEncoder()
//                .username("vamshi")
//                .password("11111")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails adminUser= User.withDefaultPasswordEncoder()
//                .username("akash")
//                .password("12321")
//                .roles("USER")
//                .build();


        //with passwordEncoder
        UserDetails normalUser= User
                .withUsername("vamshi")
                .password(passwordEncoder().encode("11111"))
                .roles("ADMIN")
                .build();

        UserDetails adminUser= User
                .withUsername("akash")
                .password(passwordEncoder().encode("12321"))
                .roles("NORMAL")
                .build();

         return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    //ROLE - High level overview-> NORMAL :READ
    //Authority - permission -> READ
    //ADMIN - READ, WRITE, UPDATE

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
