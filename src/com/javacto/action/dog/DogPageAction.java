package com.javacto.action.dog;

import com.javacto.po.Computer;
import com.javacto.po.Dog;
import com.javacto.service.ComputerService;
import com.javacto.service.DogService;
import com.javacto.service.impl.ComputerServiceImpl;
import com.javacto.service.impl.DogServiceImpl;
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
@WebServlet("/dogPage.html")
public class DogPageAction extends HttpServlet {
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
        pageInfo.setPageSize(3);
        DogService dogService = new DogServiceImpl();
        int totalCount = dogService.getTotalCount();

        pageInfo.setTotalCount(totalCount);
        List<Dog> dogs = dogService.pageQueryDog(pageInfo);
        req.setAttribute("msg",dogs);
        req.setAttribute("info",pageInfo);
        req.getRequestDispatcher("/dog/dogPageList.jsp").forward(req,resp);
    }
}

