package com.myrom.springbootdemo;

import com.myrom.springbootdemo.Interceptor.MyronInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(value = {"com.myrom.*"})
public class SpringBootDemoApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		//拦截器 排除
		registry.addInterceptor(new MyronInterceptor()).addPathPatterns("/**").excludePathPatterns("/myron");
	}
}
