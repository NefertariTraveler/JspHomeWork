package com.javacto.action.computer;

import com.javacto.po.Computer;
import com.javacto.po.Phone;
import com.javacto.service.ComputerService;
import com.javacto.service.PhoneService;
import com.javacto.service.impl.ComputerServiceImpl;
import com.javacto.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * liu
 **/
@WebServlet("/updateComputer.html")
public class UpdateComputerAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namespace = this.getServletContext().getInitParameter("namespace");
        req.setCharacterEncoding(namespace);
        resp.setContentType("text/html;charset="+namespace);
        String strId = req.getParameter("id");
        int id = 0;
        if (null != strId){
            id = Integer.parseInt(strId);
        }
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        String brand = req.getParameter("brand");
        String strSize = req.getParameter("size");
        Double size = 0.00;
        if (null!=strSize){
            size = Double.parseDouble(strSize);
        }
        String color = req.getParameter("color");
        String strSales = req.getParameter("sales");
        int sales = 0;
        if (null!=strSales){
            sales = Integer.parseInt(strSales);
        }
        Computer computer = new Computer();
        computer.setId(id);
        computer.setUserName(userName);
        computer.setPwd(pwd);
        computer.setBrand(brand);
        computer.setSize(size);
        computer.setColor(color);
        computer.setSales(sales);
        ComputerService computerService = new ComputerServiceImpl();
        computerService.updateComputer(computer);
        req.getRequestDispatcher("/computerPage.html").forward(req,resp);
    }
}
