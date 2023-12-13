package com.example.mavenweb2.demoMaven2.controller;

import org.springframework.ui.Model;
import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }


}
