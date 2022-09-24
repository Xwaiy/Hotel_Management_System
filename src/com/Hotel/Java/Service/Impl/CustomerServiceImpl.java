package com.Hotel.Java.Service.Impl;

import com.Hotel.Java.Service.CustomerService;
import com.Hotel.Java.Dao.CustomerDao;
import com.Hotel.Java.Dao.DaoImpl.CustomerDaoImpl;
import com.Hotel.Java.Entity.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public int insert(Customer customer) {
        return customerDao.insert(customer);
    }

    @Override
    public Customer CustomerbyName(String sname) {
        return customerDao.CustomerbyName(sname);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerDao.findByName(name);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}
