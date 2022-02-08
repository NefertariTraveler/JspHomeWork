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
@WebServlet("/loginComputer.html")
public class LoginComputerAction extends HttpServlet {
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
        ComputerService computerService = new ComputerServiceImpl();
        Computer login = computerService.loginComputer(userName, pwd);
        if (null != login){
            req.getRequestDispatcher("/computerPage.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("/computer/loginDog.jsp").forward(req,resp);
        }
    }
}
