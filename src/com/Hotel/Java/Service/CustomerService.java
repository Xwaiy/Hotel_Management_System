package com.Hotel.Java.Service;

import com.Hotel.Java.Entity.Customer;

import java.util.List;

public interface CustomerService {
    int insert(Customer customer);
    //根据姓名查询
    Customer CustomerbyName(String sname);
    List<Customer> findByName(String name);
    List<Customer> findAll();
}
