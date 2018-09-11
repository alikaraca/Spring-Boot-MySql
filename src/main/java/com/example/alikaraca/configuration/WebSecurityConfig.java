package com.example.alikaraca.configuration;
/*
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/ekle").permitAll()
		.antMatchers("/listele").permitAll()
		.antMatchers("/duzenle").hasAnyRole("ADMİN").anyRequest().authenticated()
		.and().httpBasic();
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN")
		     .and().withUser("standartUser").password("standartUserPassword").roles("USER");
	}
}
*/