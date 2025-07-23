package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.Security.JWTService;
import com.example.backend.dto.UserDTO;
import com.example.backend.service.UserService;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    // 사용자 정보 조회
    @GetMapping("/me")
    public ResponseEntity<?> me(@RequestHeader("Authorization") String authHeader) {
        System.out.println("들어왔니?");
    try {
        String token = authHeader.replace("Bearer ", "");
        Claims claims = jwtService.extractToken(token);  // 이미 있는 메서드

        // Long userNum = claims.get("userNum", Long.class);
        Number num = claims.get("userNum", Number.class);
        Long userNum = num.longValue();

        UserDTO user = userService.selectUserNum(userNum);
        if (user == null) return ResponseEntity.notFound().build();

        user.setUserPwd(null); // 비번 제거
        return ResponseEntity.ok(user);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰이 유효하지 않습니다.");
    }
}


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

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody UserDTO input) {
    // 1) 이메일(or 아이디)로 사용자 조회
    UserDTO user = userService.selectUserEmail(input.getUserEmail());
    if (user == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("존재하지 않는 이메일입니다.");
    }

    // 2) 비밀번호 검증 (암호화 되어 있다면 PasswordEncoder.matches 사용)
    // if (!passwordEncoder.matches(input.getUserPwd(), user.getUserPwd())) {
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호가 일치하지 않습니다.");
    // }

    // 3) JWT 발급
    String token = jwtService.createUserToken(user);  // createUserToken 만들기

    // 4) 토큰만 돌려주면 됨(권한 없음)
    return ResponseEntity.ok().body(Map.of("token", token));
}



    /** 🔹 모든 사용자 조회 */
    @GetMapping("/all")
    public ResponseEntity<?> selectAllUser() {
        List<UserDTO> users = userService.selectAllUser();
        return ResponseEntity.ok(users);
    }
    // 나중에 토큰 뽑아서 조회하는 방식으로 사용
    // @GetMapping("/one")
    // public ResponseEntity<?> selectUserNum() {
    //     try {
    //         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //         Long userNum = Long.valueOf(auth.getPrincipal().toString());

    //         UserDTO user = userService.selectUserNum(userNum);
    //         if (user != null) {
    //             return ResponseEntity.ok(user);
    //         } else {
    //             return ResponseEntity.notFound().build();
    //         }
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    //     }
    // }

    @GetMapping("/userPage/{pageNum}")
    public ResponseEntity<?> pageUser(@PathVariable("pageNum") int pageNum) {
        int pageSize = 10; // 프론트에서 변경될 수 있으면 이를 동적으로 처리 가능
        List<UserDTO> users = userService.pageUser(pageNum, pageSize);
        return ResponseEntity.ok(users);
    }

    
}
