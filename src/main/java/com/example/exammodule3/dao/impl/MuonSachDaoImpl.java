package com.example.exammodule3.dao.impl;

import com.example.exammodule3.dao.IMuonSachDao;
import com.example.exammodule3.model.MuonSach;
import com.example.exammodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MuonSachDaoImpl implements IMuonSachDao {
    private static final String INSERT_MUON_SACH =
            "INSERT INTO Muon_sach (ma_muon_sach, ma_sach, ma_hoc_sinh, trang_thai, ngay_muon, ngay_tra) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public List<MuonSach> getAllMuonSach() throws SQLException {
        return List.of();
    }

    @Override
    public void insertMuonSach(MuonSach muonSach) throws SQLException {
        try (Connection connection = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MUON_SACH)) {
            preparedStatement.setString(1, muonSach.getMaMuonSach());
            preparedStatement.setInt(2, muonSach.getMaSach());
            preparedStatement.setInt(3, muonSach.getMaHocSinh());
            preparedStatement.setBoolean(4, muonSach.isTrangThai());
            preparedStatement.setString(5, muonSach.getNgayMuon());
            preparedStatement.setString(6, muonSach.getNgayTra());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
