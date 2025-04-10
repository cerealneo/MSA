package kr.co.mimmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }

    @GetMapping("/user/login")
    public String login() {
        return "/user/login";
    }
}
