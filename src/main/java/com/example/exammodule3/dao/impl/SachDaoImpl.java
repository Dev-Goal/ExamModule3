package com.example.exammodule3.dao.impl;

import com.example.exammodule3.dao.ISachDao;
import com.example.exammodule3.model.Sach;
import com.example.exammodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachDaoImpl implements ISachDao {
    private static final String SELECT_ALL_SACH = "SELECT * FROM sach";
    private static final String SELECT_SACH_BY_ID = "SELECT * FROM sach WHERE ma_sach = ?";
    private static final String UPDATE_SO_LUONG = "UPDATE sach SET so_luong = ? WHERE ma_sach = ?";

    @Override
    public List<Sach> getAllSach() throws SQLException {
        List<Sach> sachList = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SACH)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maSach = resultSet.getInt("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                sachList.add(new Sach(maSach, tenSach, tacGia, moTa,soLuong));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sachList;
    }

    @Override
    public Sach getSachByMa(int maSach) throws SQLException {
        Sach sach = null;
        try (Connection connection = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SACH_BY_ID)){
            preparedStatement.setInt(1, maSach);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                sach = new Sach(maSach, tenSach, tacGia, moTa,soLuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sach;
    }

    @Override
    public void updateSoLuongSach(int maSach, int soLuong) throws SQLException {
        try (Connection connection = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SO_LUONG)){
            preparedStatement.setInt(1, soLuong);
            preparedStatement.setInt(2, maSach);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
