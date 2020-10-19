package com.latihan.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceInterceptor.class);

    // Used to perform operations before sending the request to the controller
    @Override
    public boolean preHandle
        (HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        logger.info("Pre Handle method is calling");
        logger.info("Remote Host : " + request.getRemoteHost());
        logger.info("Remote Address : " + request.getRemoteAddr());
        return true; // Must return true to return the response to the client
    }

    // Used to perform operations before sending the response to the client
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        logger.info("Post Handle method is Calling");
    }

    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response,
             Object handler, Exception exception) throws Exception {

        logger.info("Request and Response is completed");
    }

}
