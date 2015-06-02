package com.github.hashd.interviewhq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/", "/home").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin().loginPage("/login").permitAll()
      .and()
      .logout().permitAll()
      .and().csrf();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder)
      .usersByUsernameQuery("select username, password, enabled from users where username = ?")
      .authoritiesByUsernameQuery("select u.username, ur.role from user_roles ur inner join users u on u.user_id = ur.user_id and username = ?");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    if (encoder == null) {
      encoder = new BCryptPasswordEncoder();
    }
    return encoder;
  }
}
