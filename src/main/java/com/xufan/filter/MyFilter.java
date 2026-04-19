package com.xufan.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;


/**
 * @author XuFan
 * @create 2023-04-27-13:30
 */
@Component
@WebFilter(filterName = "two",
        urlPatterns = "/*",
        initParams = {
        @WebInitParam(name = "charset",value = "utf-8")/*这里可以放一些初始化的参数*/
})
public class MyFilter implements Filter {

    private String filterName;
    private String charset = "utf-8";
    private HttpServletRequest request;
    private HttpServletResponse response;



    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("加载自定义过滤器1");
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charset);
        request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");
        filterChain.doFilter(servletRequest, servletResponse);
    }


    public void destroy() {
        Filter.super.destroy();
    }
}
