package com.javacto.test;

import com.javacto.po.Computer;
import com.javacto.service.ComputerService;
import com.javacto.service.impl.ComputerServiceImpl;
import com.javacto.utils.PageInfo;
import org.junit.Test;

import java.util.List;

/**
 * liu
 **/
public class TestComputer {
    ComputerService computerService = new ComputerServiceImpl();
    Computer computer = new Computer();

    @Test
    public void loginComputer(){
        Computer computer = computerService.loginComputer("狂战士", "1234");
        if (null != computer){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    @Test
    public void addComputer(){
        computer.setId(3);
        computer.setUserName("剑魂");
        computer.setPwd("2222");
        computer.setBrand("联想");
        computer.setSize(25.3);
        computer.setColor("星光");
        computer.setSales(73);
        int num = computerService.addComputer(computer);
        if (num!=0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void deleteComputer(){
        int num = computerService.deleteComputer(1);
        if (num!=0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void findComputerById(){
        Computer computerById = computerService.findComputerById(2);
        System.out.println(computerById);
    }

    @Test
    public void updateComputer(){
        Computer computerById = computerService.findComputerById(2);
        computerById.setSize(23);
        int num = computerService.updateComputer(computerById);
        if (num!=0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void queryAllComputer(){
        List<Computer> computers = computerService.queryAllComputer();
        for(Computer computer: computers){
            System.out.println(computer);
        }
    }

    @Test
    public void pageQueryComputer(){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(1);
        List<Computer> computers = computerService.pageQueryComputer(pageInfo);
        for(Computer computer : computers){
            System.out.println(computer);
        }
    }

    @Test
    public void findComputerByName(){
        boolean flag = computerService.findComputerByName("狂战士1");
        if (flag){
            System.out.println("用户名已注册");
        }else {
            System.out.println("用户名可用");
        }
    }
}
