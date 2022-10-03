//package com.poly.edu.project.graduation.springSecurity;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.poly.edu.project.graduation.services.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private DataSource dataSource;
//	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new CustomUserDetailsService();
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		
//		return authProvider;
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/registerUser").permitAll()
////			.antMatchers("/users").authenticated()
////			.antMatchers("/productShop").authenticated()
//			.antMatchers("/admin/manage_product").authenticated()
//			.anyRequest().permitAll()
//			.and()
//			.formLogin()
//				.loginPage("/login")
//				.usernameParameter("email")
////				.defaultSuccessUrl("/users")
////				.defaultSuccessUrl("/productShop")
//				.defaultSuccessUrl("/admin/manage_product")
//				.permitAll();
//			http.rememberMe().rememberMeParameter("remember")
//			.and()
//			.logout().logoutSuccessUrl("/index_Home").permitAll();
//	}
//	
//	
//}
