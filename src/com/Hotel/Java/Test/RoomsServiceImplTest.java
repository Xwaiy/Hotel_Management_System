package com.Hotel.Java.Test;

import com.Hotel.Java.Service.Impl.RoomsServiceImpl;
import com.Hotel.Java.Service.RoomsService;
import com.Hotel.Java.Entity.Rooms;
import org.junit.Test;

import java.util.List;

public class RoomsServiceImplTest {
    RoomsService service = new RoomsServiceImpl();
    @Test
    public void findByRno(){
        Rooms rooms = service.findByRno("001");
        System.out.println("房号："+rooms.getRNO());
        System.out.println("房间面积："+rooms.getRArea());
        System.out.println("房间租金："+rooms.getRent());
        System.out.println("房间类型："+rooms.getRStyle());
        System.out.println("房间状态："+rooms.getRState());
        System.out.println("房间总量："+rooms.getRGross());
        System.out.println("房间余数："+rooms.getRMargin());
    }
    @Test
    public void findByStyle(){
        String style = "高级标间";
        List<Rooms> rooms = service.findByStyle(style);
        if(rooms.size()>0){
            for(Rooms rooms1:rooms){
                System.out.println("房号："+rooms1);
            }
        }else {
            System.out.println("房源已满");
        }
    }
}
