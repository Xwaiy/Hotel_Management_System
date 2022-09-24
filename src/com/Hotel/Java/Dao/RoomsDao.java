package com.Hotel.Java.Dao;

import com.Hotel.Java.Entity.Living;
import com.Hotel.Java.Entity.Rooms;

import java.util.List;

public interface RoomsDao {
    Rooms findByRno(String Rno);
    List<Rooms> findByStyle(String style);
}
