package com.Hotel.Java.Service;

import com.Hotel.Java.Entity.Administrator;

public interface AdministratorService {
    Administrator AdminLogin(String Ano, String Apassword);
    int insert(Administrator administrator);
    int deleteByAno(String Ano);
}
