package com.javacto.action.computer;

import com.javacto.service.PhoneService;
import com.javacto.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * liu
 **/
@WebServlet("/findComputerByName.html")
public class FindComputerByNameAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namespace = this.getServletContext().getInitParameter("namespace");
        req.setCharacterEncoding(namespace);
        resp.setContentType("text/html;charset="+namespace);
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("userName");
        PhoneService phoneService = new PhoneServiceImpl();
        boolean flag = phoneService.findPhoneByName(userName);
        if (flag){
            out.println("0");
        }else {
            out.println("1");
        }
    }
}

