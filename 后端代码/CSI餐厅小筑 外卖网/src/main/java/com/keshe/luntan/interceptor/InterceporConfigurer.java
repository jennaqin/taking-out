package com.keshe.luntan.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceporConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenAnalysisInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new UserPermissionInterceptor()).addPathPatterns("/**/user/**");
        registry.addInterceptor(new ManagerPermissionInterceptor()).addPathPatterns("/**/manager/**");
    }
}
