package com.Hotel.Java.Dao;

import com.Hotel.Java.Entity.Living;

import java.util.List;

public interface LivingDao {
    int insert(Living living);
    Living findByRno(String Rno);
    List<Living> findByName(String name);
}
