package com.Hotel.Java.Service.Impl;

import com.Hotel.Java.Service.RoomsService;
import com.Hotel.Java.Dao.DaoImpl.RoomsDaoImpl;
import com.Hotel.Java.Dao.RoomsDao;
import com.Hotel.Java.Entity.Rooms;

import java.util.List;

public class RoomsServiceImpl implements RoomsService {
    private RoomsDao roomsDao = new RoomsDaoImpl();

    @Override
    public Rooms findByRno(String Rno) {
        return roomsDao.findByRno(Rno);
    }

    @Override
    public List<Rooms> findByStyle(String style) {
        return roomsDao.findByStyle(style);
    }
}
