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
@Order(2)
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class CoreFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURL().toString();
        // Release login and terminal request
//         if (url.contains("login") || url.contains("terminal") || url.contains("jpg") || request.getMethod().equalsIgnoreCase("options") || url.contains("verification")) {
//            chain.doFilter(request, response);
//        } else {
//            HttpSession session = request.getSession();
//            Optional.ofNullable(session.getAttribute("user"))
//                    .map(user -> {
//                        try {
//                            chain.doFilter(request, response);
//                        } catch (IOException | ServletException e) {
//                            log.warn("-==核心过滤器跳转失败！==-", e);
//                        }
//                        return "Success!";
//                    })
//                    .orElseGet(() -> {
//                        try {
//                            String result = JSONUtil.objectToJson(ResultRtn.of(10048));
//                            log.info("-==登录超时！==-");
//                            response.getWriter().print(result);
//                        } catch (IOException e) {
//                            log.warn("-==响应失败！=-", e);
//                        }
//                        return "Error!";
//                    });
//        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}