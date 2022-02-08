package com.javacto.service.impl;

import com.javacto.dao.PhoneDao;
import com.javacto.dao.impl.PhoneDaoImpl;
import com.javacto.po.Phone;
import com.javacto.service.PhoneService;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.util.List;

/**
 * liu
 **/
public class PhoneServiceImpl implements PhoneService {
    private PhoneDao phoneDao = new PhoneDaoImpl();

    /**
     * 登录
     * @param phoneName
     * @param pwd
     * @return
     */
    public Phone login(String phoneName, String pwd){
        return phoneDao.login(phoneName,pwd);
    }

    /**
     * 添加
     */
    public int addPhone(Phone phone){
        return phoneDao.addPhone(phone);
    }

    /**
     * 删除
     */
    public int deletePhone(int id){
        return phoneDao.deletePhone(id);
    }

    /**
     * 修改
     */
    public int updatePhone(Phone phone){
        return phoneDao.updatePhone(phone);
    }

    /**
     * 查询全部
     */
    public List<Phone> queryAll(){
        return phoneDao.queryAll();
    }

    /**
     * Id查询
     */
    public Phone findPhoneById (int id){
        return phoneDao.findPhoneById(id);
    }

    /**
     * 查询总条数
     */
    public int getTotalCount(){
        return phoneDao.getTotalCount();
    }

    /**
     * 分页查询
     */
    public List<Phone> pageQueryPhone(PageInfo pageInfo){
        return phoneDao.pageQueryPhone(pageInfo);
    }

    /**
     * 根据用户名查询
     */
    public boolean findPhoneByName (String userName){
        return phoneDao.findPhoneByName(userName);
    }
}
