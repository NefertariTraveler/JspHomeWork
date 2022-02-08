package com.javacto.dao.impl;

import com.javacto.dao.PhoneDao;
import com.javacto.po.Phone;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.util.List;

/**
 * liu
 **/
public class PhoneDaoImpl implements PhoneDao {
    /**
     * 登录
     * @param phoneName
     * @param pwd
     * @return
     */
    public Phone login(String phoneName, String pwd){
        String sql = "select *from phone where ph_username=? and ph_password=?";
        Object[] objects = {phoneName,pwd};
        return BaseDao.login(sql,objects);
    }

    /**
     * 添加
     */
    public int addPhone(Phone phone){
        String sql = "INSERT INTO phone(ph_id,ph_username,ph_password,ph_brand,ph_size,ph_color,ph_sales,ph_date) " +
                "VALUES(?,?,?,?,?,?,?,NOW())";
        Object[] objects = {phone.getId(),phone.getUserName(),phone.getPwd(),phone.getBrand(),phone.getSize(),phone.getColor(),phone.getSales()};
        return BaseDao.executeUpdate(sql,objects);
    }

    /**
     * 删除
     */
    public int deletePhone(int id){
        String sql = "DELETE FROM phone WHERE ph_id=?";
        Object[] objects = {id};
        return BaseDao.executeUpdate(sql,objects);
    }

    /**
     * 修改
     */
    public int updatePhone(Phone phone){
        String sql = "UPDATE phone SET ph_username=?,ph_password=?,ph_brand=?,ph_size=?,ph_color=?,ph_sales=? WHERE ph_id=?";
        Object[] objects = {phone.getUserName(),phone.getPwd(),phone.getBrand(),phone.getSize(),phone.getColor(),phone.getSales(),phone.getId()};
        return BaseDao.executeUpdate(sql,objects);
    }

    /**
     * 查询全部
     */
    public List<Phone> queryAll(){
        String sql = "select *from phone";
        return BaseDao.queryAll(sql);
    }

    /**
     * Id查询
     */
    public Phone findPhoneById (int id){
        String sql = "SELECT *FROM phone WHERE ph_id=?";
        Object[] objects = {id};
        return BaseDao.findPhoneById(sql,objects);
    }

    /**
     * 查询总条数
     */
    public int getTotalCount(){
        String sql = "SELECT COUNT(*) FROM phone";
        return BaseDao.getTotalCount(sql);
    }

    /**
     * 分页查询
     */
    public List<Phone> pageQueryPhone(PageInfo pageInfo){
        String sql = "SELECT * FROM phone LIMIT ?,?";
        Object[] objects = {(pageInfo.getPageNo()-1)*pageInfo.getPageSize(),pageInfo.getPageSize()};
        return BaseDao.pageQueryPhone(sql,objects);
    }

    /**
     * 根据用户名查询
     */
    public boolean findPhoneByName (String userName){
        String sql = "SELECT *FROM phone WHERE ph_username=?";
        Object[] objects = {userName};
        return BaseDao.findPhoneByName(sql,objects);
    }
}
