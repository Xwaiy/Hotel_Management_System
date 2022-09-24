package com.Hotel.Java.Test;

import com.Hotel.Java.Dao.CustomerDao;
import com.Hotel.Java.Dao.DaoImpl.CustomerDaoImpl;
import com.Hotel.Java.Entity.Customer;
import org.junit.Test;

import java.util.List;

public class CustomerDaoImplTest {
    CustomerDao dao = new CustomerDaoImpl();
    @Test
    public void InsertTest(){
        Customer customer = new Customer();

        customer.setCName("全居");
        customer.setCSex("女");
        customer.setCAge(18);
        customer.setCId("123123112374798987");
        customer.setCTel("13523456593");

        int count = dao.insert(customer);
        if(count>0){
            System.out.println("恭喜，成功入住！");
            System.out.println(dao.findByName(customer.getCName()));
        }else {
            System.out.println("很遗憾，办理入住失败");
        }
    }
    @Test
    public void CustomerbyNameTest(){
        String name = "许安";
        List<Customer> customers = dao.findByName(name);
        if(customers.size()>0){
            for(Customer customer:customers){
                System.out.println(customer);
            }
        }else {
            System.out.println("查无此人");
        }
    }
    @Test
    public void findByNameTest(){
        String name = "许安";
    }

    @Test
    public void FindAllTest(){
        List<Customer> customers = dao.findAll();
        for(Customer customer:customers){
            System.out.println(customer);
        }
    }

}
