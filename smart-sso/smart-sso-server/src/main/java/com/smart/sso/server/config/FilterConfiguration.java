package com.smart.sso.server.config;

import com.smart.sso.client.ClientFilter;
import com.smart.sso.client.PermissionFilter;
import com.smart.sso.client.SmartContainer;
import com.smart.sso.client.SsoFilter;
import com.smart.sso.rpc.AuthenticationRpcService;
import com.smart.sso.server.captcha.CaptchaFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @FileName: FilterConfiguration
 * @Author: longer 199429
 * @Date: 2019-08-06 10:56
 * @Description: ${DESCRIPTION}
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean captchaFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CaptchaFilter());
        registration.addUrlPatterns("/captcha");
        return registration;
    }

    @Bean
    public FilterRegistrationBean smartFilter (@Value("${sso.app.code}") String ssoAppCode,AuthenticationRpcService authenticationRpcService) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        SmartContainer smartContainer = new SmartContainer();
        smartContainer.setIsServer(true);
        smartContainer.setAuthenticationRpcService(authenticationRpcService);

        PermissionFilter permissionFilter = new PermissionFilter(ssoAppCode);
        permissionFilter.setAuthenticationRpcService(authenticationRpcService);
        ClientFilter[] filters = new ClientFilter[2];
        filters[0] = new SsoFilter();
        filters[1] = permissionFilter;
        smartContainer.setFilters(filters);
        registration.setFilter(smartContainer);
        registration.setEnabled(true);
        registration.addUrlPatterns("/admin/*");
        registration.setOrder(1);
        return registration;
    }


}
