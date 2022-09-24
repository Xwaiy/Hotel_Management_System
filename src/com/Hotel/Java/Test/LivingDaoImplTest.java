package com.Hotel.Java.Test;

import com.Hotel.Java.Dao.LivingDao;
import com.Hotel.Java.Dao.DaoImpl.LivingDaoImpl;
import com.Hotel.Java.Entity.Living;
import org.junit.Test;

import java.util.List;

public class LivingDaoImplTest {
    LivingDao dao = new LivingDaoImpl();

    @Test
    public void insertTest(){
        Living living = new Living();

        living.setRNO("001");
        living.setLStyle("单人间");
        living.setCName("Xw");
        living.setCSex("男");
        living.setCAge(28);
        living.setCId("234858784521569842");
        living.setCTel("13456245695");
        living.setLComeDate("2022-09-19");
        living.setLLEFTDATE("2022-09-21");
        living.setAmount(100);
        living.setRent(320);

        int count = dao.insert(living);
        if(count>0){
            System.out.println("办理入住成功！");
            System.out.println(dao.findByRno(living.getRNO()));
        }else{
            System.out.println("登记失败");
        }
    }
    @Test
    public void findByRnoTest(){
        String Rno = "001";
        Living living = dao.findByRno(Rno);
        System.out.println(living);
    }
    @Test
    public void findByNameTest(){
        String name = "X";
        List<Living> livings = dao.findByName(name);
        if(livings.size()>0){
            for(Living living:livings){
                System.out.println(living);
            }
        }else {
            System.out.println("查无此人");
        }
    }
}
