package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.dao.AdminsDAO;
import com.example.backend.dto.AdminsDTO;

@Service
public class AdminsService {

    @Autowired
    private AdminsDAO adminsDAO;

    public boolean insertAdmin(AdminsDTO adminsDTO) {
        try {
            adminsDAO.insertAdmin(adminsDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<AdminsDTO> selectAllAdmins() {
        return adminsDAO.selectAllAdmins();
    }

    public AdminsDTO selectAdminNum(Long admindNum) {
        return adminsDAO.selectAdminNum(admindNum);
    }

    public AdminsDTO selectAdminEmail(String admindEmail) {
        return adminsDAO.selectAdminEmail(admindEmail);
    }

    @Transactional
    public boolean existsByAdmindEmail(String admindEmail) {
        return adminsDAO.existsByAdmindEmail(admindEmail) == 0;
    }

    public List<AdminsDTO> pageAdmins(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return adminsDAO.pageAdmins(offset, pageSize);
    }
}
