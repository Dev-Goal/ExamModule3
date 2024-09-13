package com.example.exammodule3.dao;

import com.example.exammodule3.model.HocSinh;

import java.sql.SQLException;
import java.util.List;

public interface IHocSinhDao {
    List<HocSinh> getAllHocSinh() throws SQLException;
}
