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
import java.util.Date;

/**
 * liu
 **/
@WebServlet("/addDog.html")
public class AddDogAction extends HttpServlet {
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
        String species = req.getParameter("species");
        String color = req.getParameter("color");
        String strHealth = req.getParameter("health");
        Double health = 0.00;
        if (null!=health){
            health = Double.parseDouble(strHealth);
        }
        Dog dog = new Dog();
        dog.setDogName(dogName);
        dog.setPwd(pwd);
        dog.setSpecies(species);
        dog.setColor(color);
        dog.setHealth(health);
        DogService dogService = new DogServiceImpl();
        dogService.addDog(dog);
        req.getRequestDispatcher("/dogPage.html").forward(req,resp);
    }
}
