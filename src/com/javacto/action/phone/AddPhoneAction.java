package com.javacto.action.phone;

import com.javacto.po.Phone;
import com.javacto.service.PhoneService;
import com.javacto.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * liu
 **/
@WebServlet("/addPhone.html")
public class AddPhoneAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namespace = this.getServletContext().getInitParameter("namespace");
        req.setCharacterEncoding(namespace);
        resp.setContentType("text/html;charset="+namespace);

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
        Phone phone = new Phone();
        phone.setUserName(userName);
        phone.setPwd(pwd);
        phone.setBrand(brand);
        phone.setSize(size);
        phone.setColor(color);
        phone.setSales(sales);
        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.addPhone(phone);
        req.getRequestDispatcher("/phonePage.html").forward(req,resp);
    }
}
