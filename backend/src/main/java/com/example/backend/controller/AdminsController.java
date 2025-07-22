package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.AdminsDTO;
import com.example.backend.service.AdminsService;
import com.example.backend.Security.JWTService;

@RestController
@RequestMapping("/api/admin")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @Autowired
    private JWTService jwtService;

    @GetMapping("/all")
    public ResponseEntity<?> selectAllAdmins() {
        List<AdminsDTO> admins = adminsService.selectAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/one")
    public ResponseEntity<?> selectAdminNum(@RequestParam Long admindNum) {
        AdminsDTO admin = adminsService.selectAdminNum(admindNum);
        if (admin != null) return ResponseEntity.ok(admin);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/page/{pageNum}")
    public ResponseEntity<?> pageAdmins(@PathVariable int pageNum) {
        int pageSize = 10;
        List<AdminsDTO> admins = adminsService.pageAdmins(pageNum, pageSize);
        return ResponseEntity.ok(admins);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminsDTO input) {
        AdminsDTO admin = adminsService.selectAdminEmail(input.getAdmindEmail());
        if (admin == null || !admin.getAdmindPwd().equals(input.getAdmindPwd())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }

        String token = jwtService.createAdminToken(admin);
        return ResponseEntity.ok().body(token);
    }
}
