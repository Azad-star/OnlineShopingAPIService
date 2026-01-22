
package com.Yusuf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Yusuf.handler.AuthEntryPoint;
import com.Yusuf.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	public static final String REGISTER = "/register";
	public static final String AUTHENTICATE = "/authenticate";
	public static final String REFRESH_TOKEN = "/refreshToken";

	public static final String[] SWAGGER_PATHS = {
			"/swagger-ui/**",
			"/v3/api-docs/**",
			"/swagger-ui.html"
	};

	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
    private AuthEntryPoint authEntryPoint;
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers(REGISTER, AUTHENTICATE, REFRESH_TOKEN).permitAll()
	                .requestMatchers(SWAGGER_PATHS).permitAll()
	                .anyRequest().authenticated()
	            )
	            .exceptionHandling(ex ->
	            ex.authenticationEntryPoint(authEntryPoint)
	        )

	            .sessionManagement(session ->
	                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            )
	            .authenticationProvider(daoAuthenticationProvider)
	            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	        return http.build();
	 }
	

}
