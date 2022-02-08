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
import java.util.List;

/**
 * liu
 **/
@WebServlet("/deletePhone.html")
public class DeletePhoneAction extends HttpServlet {
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
        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.deletePhone(id);
        req.getRequestDispatcher("/phonePage.html").forward(req,resp);
    }
}
