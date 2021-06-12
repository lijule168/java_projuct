package com.putao_seo.api.conf;

import com.putao_seo.api.interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PutaoSeoWebAppConfigurer implements WebMvcConfigurer {


	@Bean
	CostInterceptor costInterceptor() {
		return new CostInterceptor();
	}

	@Bean
	ArticleInterceptor articleInterceptor() {return new ArticleInterceptor(); }
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(costInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(articleInterceptor()).addPathPatterns("/article/detail/**");
    }

}