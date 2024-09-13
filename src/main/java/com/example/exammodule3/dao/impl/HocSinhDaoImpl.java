package com.example.exammodule3.dao.impl;

import com.example.exammodule3.dao.IHocSinhDao;
import com.example.exammodule3.model.HocSinh;
import com.example.exammodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocSinhDaoImpl implements IHocSinhDao {
    private static final String SELECT_ALL_HOC_SINH = "SELECT * FROM Hoc_sinh";

    @Override
    public List<HocSinh> getAllHocSinh() throws SQLException {
        List<HocSinh> hocSinhList = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOC_SINH)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maHocSinh = resultSet.getInt("ma_hoc_sinh");
                String tenHocSinh = resultSet.getString("ten_hoc_sinh");
                String lop = resultSet.getString("lop");
                hocSinhList.add(new HocSinh(maHocSinh, tenHocSinh, lop));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocSinhList;
    }
}
