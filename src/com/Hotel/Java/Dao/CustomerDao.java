package com.Hotel.Java.Dao;

import com.Hotel.Java.Entity.Customer;

import java.util.List;

public interface CustomerDao {
    //旅客入住
    int insert(Customer customer);
    //根据姓名查询
    Customer CustomerbyName(String sname);
    List<Customer> findByName(String name);
    List<Customer> findAll();
}
