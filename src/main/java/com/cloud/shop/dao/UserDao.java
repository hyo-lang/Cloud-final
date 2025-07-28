package com.cloud.shop.dao;

import com.cloud.shop.dto.UserDto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    UserDto findByUserEmailAndUserPwd(String userEmail, String userPwd);

    void insertUser(UserDto userDto);

    // 신규 추가된 관리자 통계용 DAO 메서드
    int countAllUsers();

    int countUsersRegisteredThisWeek();

    List<UserDto> selectRecentUsers();
}
