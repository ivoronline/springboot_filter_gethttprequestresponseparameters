package com.ivoronline.springboot_filter_gethttprequestresponseparameters.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyFilter extends OncePerRequestFilter {

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    //LOG HTTP REQUEST PARAMETERS
    System.out.println("MyFilter  : Code for HTTP Request");
    System.out.println(request.getProtocol  ());          //HTTP/1.1
    System.out.println(request.getServerName());          //localhost
    System.out.println(request.getServerPort());          //8080
    System.out.println(request.getParameter("username")); //myuser

    //DIVIDES HTTP REQUEST AND RESPONSE CODE
    chain.doFilter(request, response);

    //LOG HTTP RESPONSE PARAMETERS
    System.out.println("MyFilter  : Code for HTTP Response");
    System.out.println(response.getStatus());             //200

  }

}
