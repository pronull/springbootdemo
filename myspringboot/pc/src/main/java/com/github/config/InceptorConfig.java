package com.github.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qwe on 2017/7/23.
 */
@Component
public class InceptorConfig extends HandlerInterceptorAdapter {
    // preHandle()方法在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        return false;
    }

    // postHandle()方法在业务处理器处理请求之后被调用
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
//        httpServletResponse.setHeader("Access-Control-Allow-Origin","localhost");
//        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpServletResponse.setHeader("Access-Control-Expose-Headers","X-CSRF-TOKEN");
//        httpServletResponse.setHeader("X-CSRF-TOKEN",((CsrfToken)httpServletRequest.getAttribute("_csrf")).getToken());
    }

    // afterCompletion()方法在DispatcherServlet完全处理完请求后被调用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }

    @Component
    static class FilterConfig implements Filter{

        @Override
        public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println();
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

}
