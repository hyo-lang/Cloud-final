package com.example.backend.Security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.backend.dto.AdminsDTO;
import com.example.backend.dto.UserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final SecretKey key;

    @Value("${jwt.userTokenExpiration}")
    private Long userTokenExpiration;

    public JWTService(@Value("${jwt.secret}") String secret) {
        System.out.println("JWT secret: " + secret);
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    // ✅ 사용자 토큰 생성
    // public String createUserToken(Authentication authentication) {
    //     UserForLogin userForLogin = (UserForLogin) authentication.getPrincipal();
    //     Long userNum = userForLogin.getUserNum();
    //     String userStatus = userForLogin.getUserStatus().name();

    //     return Jwts.builder()
    //             .claim("userNum", userNum)
    //             .claim("userStatus", userStatus)
    //             .claim("type", "user")
    //             .setIssuedAt(new Date())
    //             .setExpiration(new Date(System.currentTimeMillis() + userTokenExpiration))
    //             .signWith(key, SignatureAlgorithm.HS256)
    //             .compact();
    // }

    public String createUserToken(UserDTO userDTO) {
    return Jwts.builder()
            .claim("userNum", userDTO.getUserNum())
            // .claim("userStatus", userDTO.getUserStatus())
            .claim("userEmail", userDTO.getUserEmail())
            .claim("type", "user")
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + userTokenExpiration))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
}

    // ✅ 관리자 토큰 생성
    public String createAdminToken(AdminsDTO adminDTO) {
        return Jwts.builder()
                .claim("admindNum", adminDTO.getAdmindNum())
                .claim("type", "admin")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + userTokenExpiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ 공통: 토큰 파싱
    public Claims extractToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            System.out.println("JWT 검증 실패: " + e.getMessage());
            throw new JwtException("Invalid JWT token", e);
        } catch (Exception e) {
            throw new RuntimeException("Token parsing error", e);
        }
    }
}
