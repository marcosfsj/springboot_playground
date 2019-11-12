package com.training.springdatajpanodto.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Using H2 database where the schema is defined by schema.sql or directly in
		// the database
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select user_name as username, password, enabled from user where user_name = ?")
			.authoritiesByUsernameQuery("select user_name as username, authority from authority where user_name= ?");

		// Using H2 database where the default schema is created by spring security
		// auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
		//	   .withUser(User.withUsername("user").password("user").roles("USER"))
		//	   .withUser(User.withUsername("admin").password("admin").roles("ADMIN"));

		// Using in memory data
		// auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER",
		// "ADMIN");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/").permitAll().and().formLogin();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
