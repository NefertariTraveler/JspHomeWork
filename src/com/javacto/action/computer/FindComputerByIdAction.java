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
@WebServlet("/findComputerById.html")
public class FindComputerByIdAction extends HttpServlet {
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
        ComputerService computerService = new ComputerServiceImpl();
        Computer computerById = computerService.findComputerById(id);
        req.setAttribute("computer",computerById);
        req.setAttribute("msg","2");
        req.getRequestDispatcher("/computer/add&updateDog.jsp").forward(req,resp);
    }
}
