package com.spring.Todo.webApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
     @Bean
     public InMemoryUserDetailsManager createUserDetailsManager(){

         UserDetails userDetails1 = getUserDetails("swapnil", "singh");
         UserDetails userDetails2 = getUserDetails("singh","swapnil");
         return new InMemoryUserDetailsManager(userDetails1,userDetails2);
     }

    private UserDetails getUserDetails(String username, String password) {
        // User Details is an Interface , and User is its implementing class
        // below code creates user with username and password

        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
               .passwordEncoder(passwordEncoder)
               .username(username)
               .password(password)
               .roles("USER","ADMIN")
               .build();
        return userDetails;
    }

    // after writing below method , spring-security uses Bcrypt password encoder for encryption,
     // and it will not match defaultPasswordEncoder user above, so login will fail.
     @Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }

     // any http request goes to SecurityFilterChain after implementing spring-security
     // below code is customizing SecurityFilterChain to disable csrf and frame options.
     // if we customize SecurityFilterChain then we need to reconfigure it again as we did below.
     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
     }

}
