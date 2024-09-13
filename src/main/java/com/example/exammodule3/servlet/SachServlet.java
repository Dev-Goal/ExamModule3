package com.example.exammodule3.servlet;

import com.example.exammodule3.dao.impl.SachDaoImpl;
import com.example.exammodule3.model.Sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listsach")
public class SachServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SachDaoImpl sachDao;

    public void init() {
        sachDao = new SachDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Sach> sachList = null;
        try {
            sachList = sachDao.getAllSach();
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("sachList", sachList);
        req.getRequestDispatcher("sach.jsp").forward(req, resp);
    }
}
