package com.javacto.dao.impl;

import com.javacto.dao.DogDao;
import com.javacto.po.Dog;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.util.List;

/**
 * liu
 **/
public class DogDaoImpl implements DogDao {

    @Override
    public Dog loginDog(String dogName, String pwd) {
        String sql = "select *from dog where dogname=? and pwd=?";
        Object[] objects = {dogName,pwd};
        return BaseDao.loginDog(sql,objects);
    }

    @Override
    public int addDog(Dog dog) {
        String sql = "INSERT INTO dog (id,dogname,pwd,species,color,health,birthday) " +
                "VALUES(?,?,?,?,?,?,NOW())";
        Object[] objects = {dog.getId(),dog.getDogName(),dog.getPwd(),dog.getSpecies(),dog.getColor(),dog.getHealth()};
        return BaseDao.executeUpdate(sql,objects);
    }

    @Override
    public int deleteDog(int id) {
        String sql = "DELETE FROM dog WHERE id=?";
        Object[] objects = {id};
        return BaseDao.executeUpdate(sql,objects);
    }

    @Override
    public int updateDog(Dog dog) {
        String sql = "UPDATE dog SET dogname=?,pwd=?,species=?,color=?,health=? WHERE id=?";
        Object[] objects = {dog.getDogName(),dog.getPwd(),dog.getSpecies(),dog.getColor(),dog.getHealth(),dog.getId()};
        return BaseDao.executeUpdate(sql,objects);
    }

    @Override
    public List<Dog> dogQueryAll() {
        String sql = "select *from dog";
        return BaseDao.dogQueryAll(sql);
    }

    @Override
    public Dog findDogById(int id) {
        String sql = "SELECT *FROM dog WHERE id=?";
        Object[] objects = {id};
        return BaseDao.findDogById(sql,objects);
    }

    /**
     * 查询总条数
     */
    public int getTotalCount(){
        String sql = "SELECT count(*) FROM dog";
        return BaseDao.getTotalCount(sql);
    }

    /**
     * 分页查询
     */
    public List<Dog> pageQueryDog(PageInfo pageInfo){
        String sql = "SELECT * FROM dog LIMIT ?,?";
        Object[] objects = {(pageInfo.getPageNo()-1)*pageInfo.getPageSize(),pageInfo.getPageSize()};
        return BaseDao.pageQueryDog(sql,objects);
    }

    /**
     * 用户名查询
     */
    public boolean findDogByName(String dogName){
        String sql = "SELECT *FROM dog WHERE dogname=?";
        Object[] objects = {dogName};
        return BaseDao.findDogByName(sql,objects);
    }
}
