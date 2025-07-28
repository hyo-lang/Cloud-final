package com.cloud.shop.service;

import com.cloud.shop.dao.UserDao;
import com.cloud.shop.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserDto login(String userEmail, String userPwd) {
        UserDto user = userDao.findByUserEmailAndUserPwd(userEmail, userPwd);
        System.out.println("UserService.login 호출됨 - user: " + user);
        return user;
    }

    // 회원가입 메서드
    public void join(UserDto userDto) {
        System.out.println("UserService.join 호출됨 - userDto: " + userDto);
        try {
            userDao.insertUser(userDto);
            System.out.println("회원가입 성공");
        } catch (Exception e) {
            System.err.println("회원가입 실패: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    // ✅ 관리자 대시보드용 통계 메서드들 추가

    // 전체 회원 수
    public int countUsers() {
        return userDao.countAllUsers();
    }

    // 이번 주 신규 가입자 수
    public int countNewUsersThisWeek() {
        return userDao.countUsersRegisteredThisWeek();
    }

    // 최근 가입 회원 리스트
    public List<UserDto> getRecentUsers() {
        return userDao.selectRecentUsers();
    }
}
