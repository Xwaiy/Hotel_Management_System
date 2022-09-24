package com.Hotel.Java.Dao.DaoImpl;

import com.Hotel.Java.Dao.AdministratorDao;
import com.Hotel.Java.Dbuilt.ConnectionDatebase;
import com.Hotel.Java.Entity.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorDaoImpl implements AdministratorDao {
    @Override
    public Administrator AdminLogin(String Ano, String Apassword) {
        Administrator administrator = null;
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT * FROM Administrator WHERE Ano = ? AND APASSWORD = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,Ano);
            pstmt.setString(2,Apassword);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                administrator = new Administrator();
                administrator.setANO(rs.getString("ANO"));
                administrator.setAName(rs.getString("ANAME"));
                administrator.setAPassword(rs.getString("APASSWORD"));
                administrator.setAPosition(rs.getString("APOSITION"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return administrator;
    }

    @Override
    public int insert(Administrator administrator) {
        int count = 0;
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "INSERT INTO Administrator (ANO,ANAME,APASSWORD,APOSITION)"
                +"VALUES (?,?,?,?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,administrator.getANO());
            pstmt.setString(2,administrator.getAName());
            pstmt.setString(3,administrator.getAPassword());
            pstmt.setString(4,administrator.getAPosition());
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return count;
    }

    @Override
    public int deleteByAno(String Ano) {
        int count = 0;
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "DELETE FROM Administrator WHERE ANO = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,Ano);
            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return count;
    }
}
