package com.Hotel.Java.Dao.DaoImpl;

import com.Hotel.Java.Dao.RoomsDao;
import com.Hotel.Java.Dbuilt.ConnectionDatebase;
import com.Hotel.Java.Entity.Living;
import com.Hotel.Java.Entity.Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDaoImpl implements RoomsDao {
    @Override
    public Rooms findByRno(String Rno) {
        Rooms rooms = null;
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT * FROM Rooms WHERE RNO = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,Rno);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                rooms = new Rooms();
                rooms.setRNO(rs.getString("RNO"));
                rooms.setRArea(rs.getString("RAREA"));
                rooms.setRent(rs.getInt("RENT"));
                rooms.setRStyle(rs.getString("RSTYLE"));
                rooms.setRState(rs.getString("RSTATE"));
                rooms.setRGross(rs.getInt("RGROSS"));
                rooms.setRMargin(rs.getInt("RMARGIN"));
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return rooms;
    }

    @Override
    public List<Rooms> findByStyle(String style) {
        List<Rooms> rooms = new ArrayList<Rooms>();
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT RNO,RENT FROM Rooms WHERE RSTYLE LIKE ? AND RSTATE = '空闲'";
        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1, style + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Rooms rooms1 = new Rooms();
                //利用当前记录各字段值设置客房表实体属性
                rooms1.setRNO(rs.getString("RNO"));
                rooms1.setRent(rs.getInt("RENT"));
                rooms.add(rooms1);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return rooms;
    }
}
