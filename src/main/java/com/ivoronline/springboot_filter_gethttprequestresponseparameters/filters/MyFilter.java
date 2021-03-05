package com.ivoronline.springboot_filter_gethttprequestresponseparameters.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyFilter extends OncePerRequestFilter {

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    //LOG HTTP REQUEST PARAMETERS: http://localhost:8080/Hello?user=myuser&password=mypassword
    System.out.println("\nREQUEST PARAMETERS: =======================================================");
    System.out.println("RequestURL:  " + request.getRequestURL ());       // http://localhost:8080/Public/Hello
    System.out.println("RequestURI:  " + request.getRequestURI ());       // /Public/Hello
    System.out.println("ServletPath: " + request.getServletPath());       // /Public/Hello
    System.out.println("QueryString: " + request.getQueryString());       // user=myuser&password=mypassword
    System.out.println("Parameter:   " + request.getParameter  ("user")); // myuser
    System.out.println("Method:      " + request.getMethod     ());       // GET
    System.out.println("Protocol:    " + request.getProtocol   ());       // HTTP/1.1
    System.out.println("ServerName:  " + request.getServerName ());       // localhost
    System.out.println("ServerPort:  " + request.getServerPort ());       // 8080

    //DIVIDES HTTP REQUEST AND RESPONSE CODE
    chain.doFilter(request, response);

    //LOG HTTP RESPONSE PARAMETERS
    System.out.println("\nRESPONSE PARAMETERS: =======================================================");
    System.out.println("Status:      " + response.getStatus());           //200
    System.out.println("ContentType: " + response.getContentType());      //text/html;charset=UTF-8

  }

}
