package com.javacto.test;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.impl.DogServiceImpl;
import com.javacto.utils.PageInfo;

import java.util.List;

/**
 * liu
 **/
public class TestDog {
    DogService dogService = new DogServiceImpl();
    Dog dog = new Dog();

    @org.junit.Test
    public void loginDog (){
        Dog loginDog = dogService.loginDog("贝贝", "888");
        if (null != loginDog){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    @org.junit.Test
    public void addDog (){
        dog.setId(3);
        dog.setDogName("雪");
        dog.setPwd("999");
        dog.setSpecies("拉布拉多");
        dog.setColor("藏青");
        dog.setHealth(63.2);
        int num = dogService.addDog(dog);
        if (num!=0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    @org.junit.Test
    public void deleteDog (){
        int num = dogService.deleteDog(3);
        if (num!=0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @org.junit.Test
    public void findDogById(){
        Dog dogById = dogService.findDogById(2);
        System.out.println(dogById);
    }

    @org.junit.Test
    public void updateDog (){
        Dog dogById = dogService.findDogById(2);
        dogById.setHealth(89.3);
        int num = dogService.updateDog(dogById);
        if (num!=0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @org.junit.Test
    public void dogQueryAll (){
        List<Dog> dogs = dogService.dogQueryAll();
        for (Dog dog: dogs){
            System.out.println(dog);
        }
    }

    @org.junit.Test
    public void pageQueryDog (){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(1);
        List<Dog> dogs = dogService.pageQueryDog(pageInfo);
        for (Dog dog: dogs){
            System.out.println(dog);
        }
    }

    @org.junit.Test
    public void findDogByName (){
        boolean flag = dogService.findDogByName("贝贝1");
        if (flag){
            System.out.println("用户名已注册");
        }else {
            System.out.println("用户名可用");
        }
    }
}
