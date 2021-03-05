package com.ivoronline.springboot_filter_gethttprequestresponseparameters.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/Public/Hello")
  public String publicHello() {
    return "Hello from Controller";
  }
}
