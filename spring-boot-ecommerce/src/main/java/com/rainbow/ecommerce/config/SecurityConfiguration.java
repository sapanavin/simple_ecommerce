package com.rainbow.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import com.okta.spring.boot.oauth.Okta;

import org.springframework.web.accept.ContentNegotiationStrategy;
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // protect endpoint /api/orders
        http.authorizeRequests(configurer ->
                        configurer
                                .antMatchers("/api/orders/**")
                                .authenticated())
                .oauth2ResourceServer()
                .jwt();

        // add CORS filters
        http.cors();

        // add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                             new HeaderContentNegotiationStrategy());

        // force a non-empty response body for 401's to make the response more friendly
        Okta.configureResourceServer401ResponseBody(http);
        
        //disable CSRF since we are not using Cookies for session tracking
        http.csrf().disable() ; 
        
        /*  BY default CSRF is enabled,
         *  CSRF performs checks on POST using Cookies 
         * Since we are not using Cookies for session tracking,
         *  CSRF says request is unauthorized.
         * 
         * therefore to resolve this issue disable CSRF. 
         * This technique is commonly used for REST API's*/
        
        
        
        
        return http.build();
    }
}







