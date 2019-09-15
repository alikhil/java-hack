package com.hardcoders.havajack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {

//    private ResourceServerTokenServices tokenServices;
//
//    @Autowired
//    public ResourceConfig(ResourceServerTokenServices tokenServices) {
//        this.tokenServices = tokenServices;
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.tokenServices(tokenServices);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers()
//            .and()
//            .authorizeRequests()
//            .antMatchers("/actuator/**", "/api-docs/**", "/oauth/*", "/sign-up/**").permitAll()
//            .antMatchers("/api/**" ).authenticated();
//    }
}
