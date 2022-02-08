package com.javacto.action.phone;

import com.javacto.po.Phone;
import com.javacto.service.PhoneService;
import com.javacto.service.impl.PhoneServiceImpl;
import com.javacto.utils.PageInfo;

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
@WebServlet("/phonePage.html")
public class PhonePageAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namespace = this.getServletContext().getInitParameter("namespace");
        req.setCharacterEncoding(namespace);
        resp.setContentType("text/html;charset="+namespace);
        PageInfo pageInfo = new PageInfo();
        String strPageNo = req.getParameter("pageNo");
        int pageNo = 1;
        if (null != strPageNo){
            pageNo = Integer.parseInt(strPageNo);
        }
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(10);
        PhoneService phoneService = new PhoneServiceImpl();
        int totalCount = phoneService.getTotalCount();
        pageInfo.setTotalCount(totalCount);
        List<Phone> list = phoneService.pageQueryPhone(pageInfo);
        req.setAttribute("msg",list);
        req.setAttribute("info",pageInfo);
        req.getRequestDispatcher("/phone/dogPageList.jsp").forward(req,resp);
    }
}

