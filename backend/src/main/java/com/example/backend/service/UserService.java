package com.example.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.dao.UserDAO;
import com.example.backend.dto.UserDTO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    // 사용자 추가 (회원가입)
    public boolean insertUser(UserDTO userDTO) {
        try {
            userDAO.insertUser(userDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 모든 사용자 조회
    public List<UserDTO> selectAllUser() {
        return userDAO.selectAllUser();
    }

    // 특정 사용자 조회
    public UserDTO selectUserNum(Long userNum) {
        return userDAO.selectUserNum(userNum);
    }

    public UserDTO selectUserName(String userName) {
        return userDAO.selectUserName(userName);
    }

    public UserDTO selectUserEmail(String userEmail) {
        return userDAO.selectUserEmail(userEmail);
    }

    // 이메일 전달
    public UserDTO selectCountUserEmail(String userEmail) {
        return userDAO.selectUserEmail(userEmail);
    }

    // 회원가입시 이메일 조회
    @Transactional
    public boolean existsByUserEmail(String userEmail) {
        if (0 == userDAO.existsByUserEmail(userEmail)) {
            return true;
        } else {
            return false;
        }
    }

    public List<UserDTO> pageUser(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return userDAO.pageUser(offset, pageSize);
    }

}