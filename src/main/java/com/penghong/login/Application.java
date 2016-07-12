package com.penghong.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.penghong.login.interceptor.LoginInterceptor;
@Configuration
@SpringBootApplication
@ComponentScan("com.*")
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}
	
	 /** 
     * 配置拦截器 
     * @author lance 
     * @param registry 
     */  
    public void addInterceptors(InterceptorRegistry registry) {  
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/user/login")
        .excludePathPatterns("/user/loginUI")
        .excludePathPatterns("/user/registerUI")
        .excludePathPatterns("/user/register"); 
        super.addInterceptors(registry);
    }  
}  
    
