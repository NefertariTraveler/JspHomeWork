package com.javacto.dao.impl;

import com.javacto.dao.ComputerDao;
import com.javacto.po.Computer;
import com.javacto.po.Phone;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.util.List;

/**
 * liu
 **/
public class ComputerDaoImpl implements ComputerDao {


    @Override
    public Computer loginComputer(String phoneName, String pwd) {
        String sql = "select *from computer where cm_username=? and cm_password=?";
        Object[] objects = {phoneName,pwd};
        return BaseDao.loginComputer(sql,objects);
    }

    @Override
    public int addComputer(Computer computer) {
        String sql = "INSERT INTO computer(cm_id,cm_username,cm_password,cm_brand,cm_size,cm_color,cm_sales,cm_date) " +
                "VALUES(?,?,?,?,?,?,?,NOW())";
        Object[] objects = {computer.getId(),computer.getUserName(),computer.getPwd(),computer.getBrand(),computer.getSize(),computer.getColor(),computer.getSales()};
        return BaseDao.executeUpdate(sql,objects);
    }

    @Override
    public int deleteComputer(int id) {
        String sql = "DELETE FROM computer WHERE cm_id=?";
        Object[] objects = {id};
        return BaseDao.executeUpdate(sql,objects);
    }

    @Override
    public int updateComputer(Computer computer) {
        String sql = "UPDATE computer SET cm_username=?,cm_password=?,cm_brand=?,cm_size=?,cm_color=?,cm_sales=? WHERE cm_id=?";
        Object[] objects = {computer.getUserName(),computer.getPwd(),computer.getBrand(),computer.getSize(),computer.getColor(),computer.getSales(),computer.getId()};
        return BaseDao.executeUpdate(sql,objects);
    }

    @Override
    public List<Computer> queryAllComputer() {
        String sql = "select *from computer";
        return BaseDao.queryAllComputer(sql);
    }

    @Override
    public Computer findComputerById(int id) {
        String sql = "SELECT *FROM computer WHERE cm_id=?";
        Object[] objects = {id};
        return BaseDao.findComputerById(sql,objects);
    }

    /**
     * 查询总条数
     */
    public int getTotalCount(){
        String sql = "SELECT COUNT(*) FROM computer";
        return BaseDao.getTotalCount(sql);
    }

    /**
     * 分页查询
     */
    public List<Computer> pageQueryComputer(PageInfo pageInfo){
        String sql = "SELECT * FROM computer LIMIT ?,?";
        Object[] objects = {(pageInfo.getPageNo()-1)*pageInfo.getPageSize(),pageInfo.getPageSize()};
        return BaseDao.pageQueryComputer(sql,objects);
    }

    /**
     * 用户名查询
     */
    public boolean findComputerByName(String userName){
        String sql = "SELECT *FROM computer WHERE cm_username=?";
        Object[] objects = {userName};
        return BaseDao.findComputerByName(sql,objects);
    }
}
