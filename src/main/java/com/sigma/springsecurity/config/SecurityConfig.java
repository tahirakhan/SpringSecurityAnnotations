package com.sigma.springsecurity.config;

/**
 * Created by Tahir on 4/25/2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("tahir").password("tahir").roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    auth.inMemoryAuthentication().withUser("dba").password("dba").roles("DBA");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
        .and().formLogin();

  }
}