package org.zerock.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@EnableWebSecurity	//얘를 통해 Configuration 붙는다고 생각하면 됨
@Log
@EnableGlobalMethodSecurity(prePostEnabled = true) //method에서 권한 확인할 수 있도록
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new ZerockUserService();
		
	}
	
	/*
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		log.info("====================cofigureGlobal========================");
		
		auth.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncoder());
		
	}
	*/
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("------------------------------------");
		log.info("configure");
		log.info("------------------------------------");
		
		http.formLogin();
		
		http.rememberMe().tokenValiditySeconds(60 * 60 * 24);
	}
	
	
	
	
}
