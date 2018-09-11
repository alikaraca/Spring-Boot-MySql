package com.example.alikaraca.configuration;

/*import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class SecurityConfiguration implements WebMvcConfigurer{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/src/main/resources/templates/", ".html");
    }
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/kayit").setViewName("kayit");
		//registry.addViewController("/login").setViewName("login");
	}
	/*protected void configure(AuthenticationManagerBuilder auth) 
		throws Exception {
			auth.
				jdbcAuthentication()
					.usersByUsernameQuery(usersQuery)
					.authoritiesByUsernameQuery(rolesQuery)
					.dataSource(dataSource)
					.passwordEncoder(bCryptPasswordEncoder);
	}
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
		authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/kayit").permitAll()
			.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
			.authenticated().and().csrf().disable().formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.defaultSuccessUrl("/admin/anasayfa")
			.usernameParameter("email")
			.passwordParameter("sifre")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/cikis"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/access-denied");
	}
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}*/
