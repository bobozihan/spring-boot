package com.mxp.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2019-03-07
 * Time : 11:17
 */
@Log4j2
@Order(1)
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        if (url.contains("terminal")) {
            log.info("-==终端请求，放行！==-");
            chain.doFilter(request, response);
        } else {
            log.info("-==前端请求，开始处理跨域！==-"+request.getMethod());
            response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST,DELETE");
            response.addHeader("Access-Control-Allow-Headers", "content-type");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
