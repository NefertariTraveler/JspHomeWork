package com.javacto.dao;

import com.javacto.po.Phone;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.util.List;

/**
 * liu
 **/
public interface PhoneDao {
    /**
     * 登录
     * @param phoneName
     * @param pwd
     * @return
     */
    public Phone login(String phoneName,String pwd);

    /**
     * 添加
     */
    public int addPhone(Phone phone);

    /**
     * 删除
     */
    public int deletePhone(int id);

    /**
     * 修改
     */
    public int updatePhone(Phone phone);

    /**
     * 查询全部
     */
    public List<Phone> queryAll();

    /**
     * Id查询
     */
    public Phone findPhoneById (int id);

    /**
     * 查询总条数
     */
    public int getTotalCount();


    /**
     * 分页查询
     */
    public List<Phone> pageQueryPhone(PageInfo pageInfo);

    /**
     * 根据用户名查询
     */
    public boolean findPhoneByName (String userName);
}
