package io.abc.springboot.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    // TODO: 2022/1/23

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter >>> init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter >>> doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter >>> destroy");
    }
}
