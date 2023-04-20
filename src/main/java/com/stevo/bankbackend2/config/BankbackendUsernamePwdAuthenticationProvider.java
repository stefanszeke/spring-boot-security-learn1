package com.stevo.bankbackend2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.stevo.bankbackend2.model.Customer;
import com.stevo.bankbackend2.repository.CustomerRepository;

@Component
public class BankbackendUsernamePwdAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String pwd = authentication.getCredentials().toString();

    UserDetails customer = userDetailsService.loadUserByUsername(username);

    System.out.println("** BankbackendUsernamePwdAuthenticationProvider: authenticate running **");

    if(passwordEncoder.matches(pwd, customer.getPassword()) == false) {
      throw new BadCredentialsException("Wrong password");
    }

    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.addAll(customer.getAuthorities());


    System.out.println("authorities: " + authorities);
    return new UsernamePasswordAuthenticationToken(pwd, customer, authorities);
    
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return(UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)); // checks if the authentication is of type UsernamePasswordAuthenticationToken
  }
  
}
