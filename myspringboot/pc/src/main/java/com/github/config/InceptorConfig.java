package com.github.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.access.method.AbstractMethodSecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by qwe on 2017/7/23.
 */
//@Component
//public class InceptorConfig extends AbstractSecurityInterceptor implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        FilterInvocation fi =  new FilterInvocation(servletRequest,servletResponse,filterChain);
//        invoke(fi);
//    }
//
//    private void invoke(FilterInvocation fi) {
//        InterceptorStatusToken token = super.beforeInvocation(fi);
//        try {
//            fi.getChain().doFilter(fi.getRequest(),fi.getResponse());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }finally {
//            super.afterInvocation(token,null);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public Class<?> getSecureObjectClass() {
//        return null;
//    }
//
//    @Override
//    public SecurityMetadataSource obtainSecurityMetadataSource() {
//        return null;
//    }
//
//
//}
