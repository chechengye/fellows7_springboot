package com.lovecoding.fellows7_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickStartController {

    @RequestMapping("/quickStart")
    @ResponseBody
    public String testFn(){
        return "Quick Start Success!!!";
    }
}
