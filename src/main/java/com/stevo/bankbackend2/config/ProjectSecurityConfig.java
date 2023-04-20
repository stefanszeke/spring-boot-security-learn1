package com.stevo.bankbackend2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;


@Configuration
public class ProjectSecurityConfig {


  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/MyAccount", "/MyBalance", "MyLoans", "MyCards").authenticated()
            .requestMatchers("/contact", "/notices", "/register").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults());

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }








  // @Bean
  // public InMemoryUserDetailsManager userDetailsService() {
  // UserDetails admin = User.withDefaultPasswordEncoder()
  // .username("admin")
  // .password("admin")
  // .roles("admin")
  // .build();

  // UserDetails user = User.withDefaultPasswordEncoder()
  // .username("user")
  // .password("user")
  // .roles("user")
  // .build();

  // return new InMemoryUserDetailsManager(admin, user);
  // }

  // @Bean
  // public UserDetailsService userDetailsService(DataSource dataSource) {
  // return new JdbcUserDetailsManager(dataSource);
  // }

}
