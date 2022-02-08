package com.javacto.test;

import com.javacto.po.Phone;
import com.javacto.service.PhoneService;
import com.javacto.service.impl.PhoneServiceImpl;
import com.javacto.utils.PageInfo;
import org.junit.Test;

import java.util.List;

/**
 * liu
 **/
public class TestPhone {
    PhoneService phoneService = new PhoneServiceImpl();
    Phone phone = new Phone();

    @org.junit.Test
    public void login (){
        Phone login = phoneService.login("绯红", "2222");
        if (null != login){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    @org.junit.Test
    public void addPhone (){
        phone.setId(4);
        phone.setUserName("战场疾风");
        phone.setPwd("4444");
        phone.setBrand("魅族");
        phone.setSize(14.4);
        phone.setColor("红色");
        phone.setSales(33);
        int num = phoneService.addPhone(phone);
        if (num!=0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    @org.junit.Test
    public void deletePhone (){
        int num = phoneService.deletePhone(1);
        if (num!=0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @org.junit.Test
    public void findPhoneById(){
        Phone phoneById = phoneService.findPhoneById(4);
        System.out.println(phoneById);
    }

    @org.junit.Test
    public void updatePhone (){
        Phone phoneById = phoneService.findPhoneById(4);
        phoneById.setSales(44);
        int num = phoneService.updatePhone(phoneById);
        if (num!=0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @org.junit.Test
    public void queryAll (){
        List<Phone> list = phoneService.queryAll();
        for (Phone phone: list){
            System.out.println(phone);
        }
    }

    @Test
    public void getTotalCount(){
        int totalCount = phoneService.getTotalCount();
        System.out.println(totalCount);
    }

    @Test
    public void pageQueryPhone(){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNo(2);
        List<Phone> list = phoneService.pageQueryPhone(pageInfo);
        for (Phone phone : list){
            System.out.println(phone);
        }
    }

    @Test
    public void findPhoneByName(){
        boolean flag = phoneService.findPhoneByName("战车");
        if (flag){
            System.out.println("用户名已注册");
        }else {
            System.out.println("用户名可用");
        }
    }
}
