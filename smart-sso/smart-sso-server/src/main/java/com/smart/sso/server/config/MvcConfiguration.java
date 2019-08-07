package com.smart.sso.server.config;

import com.smart.sso.server.common.LocalTokenManager;
import com.smart.sso.server.common.TokenManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @FileName: MvcConfiguration
 * @Author: longer 199429
 * @Date: 2019-08-06 10:53
 * @Description: ${DESCRIPTION}
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean
    public TokenManager tokenManager() {
        return new LocalTokenManager();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "admin/admin");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/smart-static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
