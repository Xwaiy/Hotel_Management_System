package com.Hotel.Java.Dao;

import com.Hotel.Java.Entity.Administrator;

public interface AdministratorDao {
    Administrator AdminLogin(String Ano,String Apassword);
    int insert(Administrator administrator);
    int deleteByAno(String Ano);
}
