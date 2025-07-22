package com.example.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.backend.dto.UserDTO;

@Mapper
public interface UserDAO {

    void insertUser(UserDTO userDTO);

    List<UserDTO> selectAllUser();

    UserDTO selectUserNum(Long userNum);

    UserDTO selectUserName(String userName);

    UserDTO selectUserEmail(String userEmail);

    // 회원가입 중복검사
    int existsByUserEmail(String userEmail);

    List<UserDTO> pageUser(@Param("offset") int offset, @Param("pageSize") int pageSize);


}