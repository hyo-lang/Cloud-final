package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.UserDTO;
import com.example.backend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO) {

    // 1) 필수값 검증 (간단히라도)
    if (userDTO.getUserEmail() == null || userDTO.getUserPwd() == null) {
        return ResponseEntity.badRequest().body("필수 입력값 누락");
    }

    // 2) 이메일 중복 체크 (true = 사용 가능으로 바꾸는 게 직관적)
    // if (!userService.isEmailAvailable(userDTO.getUserEmail())) {
    //     return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 이메일입니다.");
    // }

    // 3) 비밀번호 암호화 (스프링 시큐리티 PasswordEncoder 사용 권장)
    // userDTO.setUserPwd(passwordEncoder.encode(userDTO.getUserPwd()));

    // 4) Insert
    if (userService.insertUser(userDTO)) {
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
}


    /** 🔹 모든 사용자 조회 */
    @GetMapping("/all")
    public ResponseEntity<?> selectAllUser() {
        List<UserDTO> users = userService.selectAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/one")
    public ResponseEntity<?> selectUserNum() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Long userNum = Long.valueOf(auth.getPrincipal().toString());

            UserDTO user = userService.selectUserNum(userNum);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @GetMapping("/userPage/{pageNum}")
    public ResponseEntity<?> pageUser(@PathVariable("pageNum") int pageNum) {
        int pageSize = 10; // 프론트에서 변경될 수 있으면 이를 동적으로 처리 가능
        List<UserDTO> users = userService.pageUser(pageNum, pageSize);
        return ResponseEntity.ok(users);
    }

    
}
