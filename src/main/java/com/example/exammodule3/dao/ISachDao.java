package com.example.exammodule3.dao;

import com.example.exammodule3.model.Sach;

import java.sql.SQLException;
import java.util.List;

public interface ISachDao {
    List<Sach> getAllSach() throws SQLException;
    Sach getSachByMa(int maSach) throws SQLException;
    void updateSoLuongSach(int maSach, int soLuong) throws SQLException;
}