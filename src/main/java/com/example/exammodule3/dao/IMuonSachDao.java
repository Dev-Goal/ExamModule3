package com.example.exammodule3.dao;

import com.example.exammodule3.model.MuonSach;

import java.sql.SQLException;
import java.util.List;

public interface IMuonSachDao {
    List<MuonSach> getAllMuonSach() throws SQLException;
    void insertMuonSach(MuonSach muonSach) throws SQLException;
}
