package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.antMatcher("/admin/**")
        .addFilter(getDigestAuthenticationFilter())
        .exceptionHandling().authenticationEntryPoint(getDigestAuthenticationEntryPoint())
        .and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

  }

  private DigestAuthenticationFilter getDigestAuthenticationFilter() throws Exception {
    DigestAuthenticationFilter filter = new DigestAuthenticationFilter();
    filter.setAuthenticationEntryPoint(getDigestAuthenticationEntryPoint());
    filter.setUserDetailsService(userDetailsServiceBean());
    return filter;

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("user")
        .password("password").roles("USER")
        .and()
        .withUser("admin")
        .password("password").roles("ADMIN");

  }

  @Override
  @Bean
  public UserDetailsService userDetailsServiceBean() throws Exception {
    return super.userDetailsServiceBean();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder(){
    return NoOpPasswordEncoder.getInstance();
  }



  private DigestAuthenticationEntryPoint getDigestAuthenticationEntryPoint(){
    DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
    entryPoint.setRealmName("admin-realm");
    entryPoint.setKey("fkdfjdkf_df_2e");
    return entryPoint;
  }

}
