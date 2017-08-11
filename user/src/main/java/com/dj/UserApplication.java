package com.dj;

import com.dj.user.config.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.dj.user.dao")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilterRegistrationBean(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CorsFilter httpBearerFilter = new CorsFilter();
		registrationBean.setFilter(httpBearerFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/users/login");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
}
