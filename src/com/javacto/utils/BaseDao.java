package com.javacto.utils;

import com.javacto.po.Computer;
import com.javacto.po.Dog;
import com.javacto.po.Phone;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * liu
 **/
public class BaseDao {
    private static String driverManagerName;
    private static String url;
    private static String userName;
    private static String pwd;

    //类加载之前会执行的代码
    static {
        init();
    }

    //这个方法代码大家都不需要会写，也不用记，会复制就可以，因为以后不会这样写  现在是讲思路
    private static void init() {
        //这个方法只有一个目的，拿到db.properties 的信息 通过键获取值
        ///1.创建Properties
        Properties ps = new Properties();
        //2.拿到文件路径
        String path = "db.properties";
        //3.通过输出流读取db.properties 中的信息 数据
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(path);
        try {
            //4.把读到到的数据 加载到Properties
            ps.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //5.通过键  获取值，值都在  Properties 对象中
        //System.out.println(ps.get("db.driverName"));
        //System.out.println(ps.getProperty("db.url"));

        //赋值  大家必需通过    System.out.println(ps.get("db.driverName")); 输出 有值了再赋值
        driverManagerName=ps.getProperty("db.driverManagerName");
        url=ps.getProperty("db.url");
        userName=ps.getProperty("db.userName");
        pwd=ps.getProperty("db.pwd");
    }

    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(driverManagerName);
            //2.建立连接  Connection
            conn = DriverManager.getConnection(url,userName,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    //希望所有同学，每次创建新的工程，如果使用BaseDao, 请务必这样测试
    public static void main(String[] args) {
        System.out.println(BaseDao.getConnection());
    }

    public static void closeAll(ResultSet resultSet, PreparedStatement pstm,Connection conn){
        try{
            if (null != resultSet){
                resultSet.close();
            }
            if (null != pstm){
                pstm.close();
            }
            if (null != conn){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int executeUpdate(String sql,Object information[]){
        int num = 0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            num = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(null,pstm,conn);
        }
        return num;
    }

    //Phone相关

    public static Phone login(String sql,Object information[]){
        Phone phone = null;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                phone = new Phone();
                phone.setId(resultSet.getInt("ph_id"));
                phone.setUserName(resultSet.getString("ph_username"));
                phone.setPwd(resultSet.getString("ph_password"));
                phone.setBrand(resultSet.getString("ph_brand"));
                phone.setSize(resultSet.getDouble("ph_size"));
                phone.setColor(resultSet.getString("ph_color"));
                phone.setSales(resultSet.getInt("ph_sales"));
                phone.setDate(resultSet.getDate("ph_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return phone;
    }

    public static List<Phone> queryAll(String sql){
        List<Phone> list = new ArrayList<Phone>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Phone phone1 = new Phone();
                phone1.setId(resultSet.getInt("ph_id"));
                phone1.setUserName(resultSet.getString("ph_username"));
                phone1.setPwd(resultSet.getString("ph_password"));
                phone1.setBrand(resultSet.getString("ph_brand"));
                phone1.setSize(resultSet.getDouble("ph_size"));
                phone1.setColor(resultSet.getString("ph_color"));
                phone1.setSales(resultSet.getInt("ph_sales"));
                phone1.setDate(resultSet.getDate("ph_date"));
                list.add(phone1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return list;
    }

    public static Phone findPhoneById(String sql,Object information[]){
        Phone phone = null;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                phone = new Phone();
                phone.setId(resultSet.getInt("ph_id"));
                phone.setUserName(resultSet.getString("ph_username"));
                phone.setPwd(resultSet.getString("ph_password"));
                phone.setBrand(resultSet.getString("ph_brand"));
                phone.setSize(resultSet.getDouble("ph_size"));
                phone.setColor(resultSet.getString("ph_color"));
                phone.setSales(resultSet.getInt("ph_sales"));
                phone.setDate(resultSet.getDate("ph_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return phone;
    }

    //Computer相关

    public static Computer loginComputer(String sql, Object information[]){
        Computer computer = null;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                computer = new Computer();
                computer.setId(resultSet.getInt("cm_id"));
                computer.setUserName(resultSet.getString("cm_username"));
                computer.setPwd(resultSet.getString("cm_password"));
                computer.setBrand(resultSet.getString("cm_brand"));
                computer.setSize(resultSet.getDouble("cm_size"));
                computer.setColor(resultSet.getString("cm_color"));
                computer.setSales(resultSet.getInt("cm_sales"));
                computer.setDate(resultSet.getDate("cm_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return computer;
    }

    public static List<Computer> queryAllComputer(String sql){
        List<Computer> list = new ArrayList<Computer>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Computer computer = new Computer();
                computer.setId(resultSet.getInt("cm_id"));
                computer.setUserName(resultSet.getString("cm_username"));
                computer.setPwd(resultSet.getString("cm_password"));
                computer.setBrand(resultSet.getString("cm_brand"));
                computer.setSize(resultSet.getDouble("cm_size"));
                computer.setColor(resultSet.getString("cm_color"));
                computer.setSales(resultSet.getInt("cm_sales"));
                computer.setDate(resultSet.getDate("cm_date"));
                list.add(computer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return list;
    }

    public static Computer findComputerById(String sql,Object information[]){
        Computer computer = null;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                computer = new Computer();
                computer.setId(resultSet.getInt("cm_id"));
                computer.setUserName(resultSet.getString("cm_username"));
                computer.setPwd(resultSet.getString("cm_password"));
                computer.setBrand(resultSet.getString("cm_brand"));
                computer.setSize(resultSet.getDouble("cm_size"));
                computer.setColor(resultSet.getString("cm_color"));
                computer.setSales(resultSet.getInt("cm_sales"));
                computer.setDate(resultSet.getDate("cm_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return computer;
    }

    //Dog相关

    public static Dog loginDog(String sql, Object information[]){
        Dog dog = null;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                dog = new Dog();
                dog.setId(resultSet.getInt("id"));
                dog.setDogName(resultSet.getString("dogname"));
                dog.setPwd(resultSet.getString("pwd"));
                dog.setSpecies(resultSet.getString("species"));
                dog.setColor(resultSet.getString("color"));
                dog.setHealth(resultSet.getDouble("health"));
                dog.setDate(resultSet.getDate("birthday"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return dog;
    }

    public static List<Dog> dogQueryAll(String sql){
        List<Dog> list = new ArrayList<Dog>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Dog dog = new Dog();
                dog.setId(resultSet.getInt("id"));
                dog.setDogName(resultSet.getString("dogname"));
                dog.setPwd(resultSet.getString("pwd"));
                dog.setSpecies(resultSet.getString("species"));
                dog.setColor(resultSet.getString("color"));
                dog.setHealth(resultSet.getDouble("health"));
                dog.setDate(resultSet.getDate("birthday"));
                list.add(dog);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return list;
    }

    public static Dog findDogById(String sql,Object information[]){
        Dog dog = null;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                dog = new Dog();
                dog.setId(resultSet.getInt("id"));
                dog.setDogName(resultSet.getString("dogname"));
                dog.setPwd(resultSet.getString("pwd"));
                dog.setSpecies(resultSet.getString("species"));
                dog.setColor(resultSet.getString("color"));
                dog.setHealth(resultSet.getDouble("health"));
                dog.setDate(resultSet.getDate("birthday"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return dog;
    }

    //获取总条数
    public static int getTotalCount(String sql){
        int count = 0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return count;
    }

    //分页查询Phone
    public static List<Phone> pageQueryPhone(String sql, Object information[]){
        List<Phone> list = new ArrayList<Phone>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Phone phone1 = new Phone();
                phone1.setId(resultSet.getInt("ph_id"));
                phone1.setUserName(resultSet.getString("ph_username"));
                phone1.setPwd(resultSet.getString("ph_password"));
                phone1.setBrand(resultSet.getString("ph_brand"));
                phone1.setSize(resultSet.getDouble("ph_size"));
                phone1.setColor(resultSet.getString("ph_color"));
                phone1.setSales(resultSet.getInt("ph_sales"));
                phone1.setDate(resultSet.getDate("ph_date"));
                list.add(phone1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return list;
    }

    public static boolean findPhoneByName(String sql,Object information[]){
        boolean b = false;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                b = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return b;
    }

    //分页查询Computer
    public static List<Computer> pageQueryComputer(String sql, Object information[]){
        List<Computer> list = new ArrayList<Computer>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Computer computer = new Computer();
                computer.setId(resultSet.getInt("cm_id"));
                computer.setUserName(resultSet.getString("cm_username"));
                computer.setPwd(resultSet.getString("cm_password"));
                computer.setBrand(resultSet.getString("cm_brand"));
                computer.setSize(resultSet.getDouble("cm_size"));
                computer.setColor(resultSet.getString("cm_color"));
                computer.setSales(resultSet.getInt("cm_sales"));
                computer.setDate(resultSet.getDate("cm_date"));
                list.add(computer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return list;
    }

    public static boolean findComputerByName(String sql,Object information[]){
        boolean b = false;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                b = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return b;
    }

    //分页查询dog
    public static List<Dog> pageQueryDog(String sql,Object information[]){
        List<Dog> list = new ArrayList<Dog>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Dog dog = new Dog();
                dog.setId(resultSet.getInt("id"));
                dog.setDogName(resultSet.getString("dogname"));
                dog.setPwd(resultSet.getString("pwd"));
                dog.setSpecies(resultSet.getString("species"));
                dog.setColor(resultSet.getString("color"));
                dog.setHealth(resultSet.getDouble("health"));
                dog.setDate(resultSet.getDate("birthday"));
                list.add(dog);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return list;
    }

    public static boolean findDogByName(String sql,Object information[]){
        boolean b = false;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <information.length ; i++) {
                pstm.setObject(i+1,information[i]);
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                b = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,pstm,conn);
        }
        return b;
    }
}
