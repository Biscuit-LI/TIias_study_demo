package com.jerry.tilas.filter;


import com.jerry.tilas.util.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("FilterDemo init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("FilterDemo doFilter");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri=httpServletRequest.getRequestURI();
        if(uri.contains("login")){
            log.info("login请求，放行");
            chain.doFilter(request,response);
            return;
        }
        String token=httpServletRequest.getHeader("token");
        if(token==null||token.isEmpty()){
            log.info("令牌无效");
            httpServletResponse.setStatus(401);
            return;
        }
        if(JwtUtils.isValid(token)){
            log.info("令牌有效，放行");
            chain.doFilter(request,response);
        }else{
            log.info("令牌无效");
            httpServletResponse.setStatus(401);
            return;
        }
    }

    @Override
    public void destroy() {
        log.info("FilterDemo destroy");
    }
}
