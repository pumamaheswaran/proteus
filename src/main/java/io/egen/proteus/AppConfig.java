package io.egen.proteus;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.egen.proteus.interceptor.LoginInterceptor;

/**
 * A spring specific class.
 * @author Pravin Umamaheswaran
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/users","/users/login");		
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**/*")
		  .allowedOrigins("*")
		  .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
		  .allowCredentials(false).
		  maxAge(3600);
	}
}
