package com.example.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.backend.dto.AdminsDTO;

@Mapper
public interface AdminsDAO {

    void insertAdmin(AdminsDTO adminDTO);

    List<AdminsDTO> selectAllAdmins();

    AdminsDTO selectAdminNum(Long admindNum);

    AdminsDTO selectAdminEmail(String admindEmail);

    int existsByAdmindEmail(String admindEmail);

    List<AdminsDTO> pageAdmins(@Param("offset") int offset, @Param("pageSize") int pageSize);
}
