package com.Hotel.Java.Service;

import com.Hotel.Java.Entity.Rooms;

import java.util.List;

//服务接口
public interface RoomsService {
    Rooms findByRno(String Rno);
    List<Rooms> findByStyle(String style);
}
