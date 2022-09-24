package com.Hotel.Java.Service.Impl;

import com.Hotel.Java.Service.AdministratorService;
import com.Hotel.Java.Dao.AdministratorDao;
import com.Hotel.Java.Dao.DaoImpl.AdministratorDaoImpl;
import com.Hotel.Java.Entity.Administrator;

public class AdministratorServiceImpl implements AdministratorService {
    private AdministratorDao administratorDao = new AdministratorDaoImpl();
    @Override
    public Administrator AdminLogin(String Ano, String Apassword) {
        return administratorDao.AdminLogin(Ano,Apassword);
    }

    @Override
    public int insert(Administrator administrator) {
        return administratorDao.insert(administrator);
    }

    @Override
    public int deleteByAno(String Ano) {
        return administratorDao.deleteByAno(Ano);
    }
}
