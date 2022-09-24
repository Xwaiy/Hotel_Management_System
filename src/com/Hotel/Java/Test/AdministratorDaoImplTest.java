package com.Hotel.Java.Test;

import com.Hotel.Java.Dao.AdministratorDao;
import com.Hotel.Java.Dao.DaoImpl.AdministratorDaoImpl;
import com.Hotel.Java.Entity.Administrator;
import org.junit.Test;

public class AdministratorDaoImplTest {
    AdministratorDao dao = new AdministratorDaoImpl();
    @Test
    public void AdminLogin(){
        String Ano,Apassword;
        Ano = "007";
        Apassword = "1234";
        Administrator administrator = dao.AdminLogin(Ano,Apassword);
        if(administrator != null){
            System.out.println("恭喜，登录成功！");
        }else {
            System.out.println("登录失败");
        }
    }
    @Test
    public void insertTest(){
        Administrator administrator = new Administrator();
        administrator.setANO("001");
        administrator.setAName("ywaix");
        administrator.setAPassword("45678");
        administrator.setAPosition("经理");
        int count = dao.insert(administrator);
        if(count>0){
            System.out.println("添加成功！");
        }else {
            System.out.println("插入失败");
        }
    }
}
