package com.cloud.shop.controller;

import com.cloud.shop.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMainPage(HttpSession session, Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        model.addAttribute("user", user); // null이면 JSP에서 자동으로 안 나옴
        return "main";
    }
}
