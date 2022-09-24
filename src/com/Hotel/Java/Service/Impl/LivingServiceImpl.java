package com.Hotel.Java.Service.Impl;

import com.Hotel.Java.Service.LivingService;
import com.Hotel.Java.Dao.DaoImpl.LivingDaoImpl;
import com.Hotel.Java.Dao.LivingDao;
import com.Hotel.Java.Entity.Living;

import java.util.List;

public class LivingServiceImpl implements LivingService {
    private LivingDao livingDao = new LivingDaoImpl();
    @Override
    public int insert(Living living) {
        return livingDao.insert(living);
    }

    @Override
    public Living findByRno(String Rno) {
        return livingDao.findByRno(Rno);
    }

    @Override
    public List<Living> findByName(String name) {
        return livingDao.findByName(name);
    }

}
