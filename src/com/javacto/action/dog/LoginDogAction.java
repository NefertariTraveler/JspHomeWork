package com.javacto.action.dog;

import com.javacto.po.Computer;
import com.javacto.po.Dog;
import com.javacto.service.ComputerService;
import com.javacto.service.DogService;
import com.javacto.service.impl.ComputerServiceImpl;
import com.javacto.service.impl.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * liu
 **/
@WebServlet("/loginDog.html")
public class LoginDogAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namespace = this.getServletContext().getInitParameter("namespace");
        req.setCharacterEncoding(namespace);
        resp.setContentType("text/html;charset="+namespace);
        String dogName = req.getParameter("dogName");
        String pwd = req.getParameter("pwd");
        DogService dogService = new DogServiceImpl();
        Dog loginDog = dogService.loginDog(dogName, pwd);
        if (null != loginDog){
            req.getRequestDispatcher("/dogPage.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("/dog/loginDog.jsp").forward(req,resp);
        }
    }
}
