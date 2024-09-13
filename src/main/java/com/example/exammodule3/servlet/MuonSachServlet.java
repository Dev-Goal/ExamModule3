package com.example.exammodule3.servlet;

import com.example.exammodule3.dao.impl.HocSinhDaoImpl;
import com.example.exammodule3.dao.impl.MuonSachDaoImpl;
import com.example.exammodule3.dao.impl.SachDaoImpl;
import com.example.exammodule3.model.HocSinh;
import com.example.exammodule3.model.MuonSach;
import com.example.exammodule3.model.Sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/muonsach")
public class MuonSachServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SachDaoImpl sachDAO;
    private HocSinhDaoImpl hocSinhDAO;
    private MuonSachDaoImpl muonSachDAO;

    public void init() {
        sachDAO = new SachDaoImpl();
        hocSinhDAO = new HocSinhDaoImpl();
        muonSachDAO = new MuonSachDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maSach = Integer.parseInt(req.getParameter("maSach"));
        Sach sach = null;
        try {
            sach = sachDAO.getSachByMa(maSach);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<HocSinh> hocSinhList = null;
        try {
            hocSinhList = hocSinhDAO.getAllHocSinh();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (sach.getSoLuong() == 0) {
            req.setAttribute("error", "Số lượng sách đã hết, không thể mượn.");
            req.getRequestDispatcher("listsach").forward(req, resp);
            return;
        }
        req.setAttribute("sach", sach);
        req.setAttribute("hocSinhList", hocSinhList);
        req.getRequestDispatcher("muonsach.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maMuonSach = req.getParameter("maMuonSach");
        int maSach = Integer.parseInt(req.getParameter("maSach"));
        int maHocSinh = Integer.parseInt(req.getParameter("maHocSinh"));
        String ngayTra = req.getParameter("ngayTra");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngayMuon = simpleDateFormat.format(new Date());
        MuonSach muonSach = new MuonSach(maMuonSach, maSach, maHocSinh, true, ngayMuon, ngayTra);
        try {
            muonSachDAO.insertMuonSach(muonSach);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            sachDAO.updateSoLuongSach(maSach, -1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("listsach");
    }
}
