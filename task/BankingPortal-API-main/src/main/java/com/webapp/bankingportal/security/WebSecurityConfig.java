package com.webapp.bankingportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	  // Configure global authentication manager using userDetailsService and passwordEncoder
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	// Define password encoder bean
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	 // Define authentication manager bean
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	  // Configure security filter chain
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


		http.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/api/users/register").permitAll()
				.requestMatchers("/api/users/login").permitAll()
				.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				 .requestMatchers("swagger-ui.html","/v3/api-docs/**","/swagger-ui/**").permitAll()
				.anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
