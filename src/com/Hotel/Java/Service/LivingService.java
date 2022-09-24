package com.Hotel.Java.Service;

import com.Hotel.Java.Entity.Living;

import java.util.List;

public interface LivingService {
    int insert(Living living);
    Living findByRno(String Rno);
    List<Living> findByName(String name);
}
