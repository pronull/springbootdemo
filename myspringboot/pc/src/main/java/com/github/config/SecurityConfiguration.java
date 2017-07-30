package com.github.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qwe on 2017/7/15.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //默认form登录的地址是/manage/j_spring_security_check,此时会调用UsernamePasswordAuthenticationFilter的attemptAuthentication方法进行认证
        http.authorizeRequests()
                .antMatchers("/*").permitAll()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll() //设置跨域
                .antMatchers("/user/**").hasRole("USER").requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN").requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .and().rememberMe().tokenValiditySeconds(1209600)
                .and().formLogin().loginPage("/#/login").loginProcessingUrl("/manage/j_spring_security_check").permitAll()
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("1").password("1").roles("USER");
        auth.inMemoryAuthentication()
                .withUser("2").password("2").roles("ADMIN");
    }

}

