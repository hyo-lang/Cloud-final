package com.cloud.shop.controller;

import com.cloud.shop.dto.UserDto;
import com.cloud.shop.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 로그인 폼 보여주기
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // 로그인 처리
   @PostMapping("/login") 
    public String login(
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userPwd") String userPwd,
            HttpSession session,
            Model model) {

        UserDto user = userService.login(userEmail, userPwd);
        System.out.println("loginUser: " + user);

        if (user != null) {
            session.setAttribute("loginUser", user);
            session.setAttribute("loginMessage", "로그인에 성공했습니다!");
            System.out.println("세션에 loginUser 저장됨");

            if ("2".equals(user.getGrade())) {
                return "redirect:/admin_main";
            } else {
                return "redirect:/user_main";
            }
        } else {
            session.setAttribute("loginMessage", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "redirect:/login";
        }
    }


  @GetMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화

        // 클라이언트에게 바로 스크립트 응답 (팝업 띄우고 main으로 이동)
        return "<script>"
            + "alert('로그아웃 되었습니다.');"
            + "window.location.href = '/main';"
            + "</script>";
    }



    
    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserDto userDto, Model model, HttpSession session) {
        try {
            System.out.println("회원가입 요청 데이터: " + userDto);
            userService.join(userDto);
            session.setAttribute("joinSuccess", true);
            return "redirect:/join";
        } catch (Exception e) {
            System.out.println("회원가입 실패: " + e.getMessage());
            session.setAttribute("joinFailed", true);
            return "redirect:/join";
        }
    }

    // 로그인 안 한 사용자용 메인 페이지
    @GetMapping("/main")
    public String main(HttpSession session, Model model) {
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        model.addAttribute("user", loginUser);
        // 로그인 안 했으면 user는 null, 그냥 기본 메인 페이지 보여줌
        return "main";  // main.jsp 뷰
    }

    // 일반 사용자 메인 페이지
    @GetMapping("/user_main")
    public String userMain(HttpSession session, Model model) {
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", loginUser);
        return "user_main"; // user_main.jsp 뷰
    }

    // 관리자 메인 페이지

    @GetMapping("/admin_main")
    public String adminMain(HttpSession session, Model model) {
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", loginUser);

        // 추가된 통계 데이터
        model.addAttribute("totalUsers", userService.countUsers());
        model.addAttribute("newUsersThisWeek", userService.countNewUsersThisWeek());
        model.addAttribute("recentUsers", userService.getRecentUsers());
        model.addAttribute("todayVisits", 123); // TODO: 방문자 수 로직 필요
        model.addAttribute("totalSales", "$80,050,000"); // TODO: 매출 로직 필요

        return "admin_main";
    }

}
