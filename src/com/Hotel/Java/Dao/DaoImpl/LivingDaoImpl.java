package com.Hotel.Java.Dao.DaoImpl;

import com.Hotel.Java.Dao.LivingDao;
import com.Hotel.Java.Dbuilt.ConnectionDatebase;
import com.Hotel.Java.Entity.Living;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//入住登记表
public class LivingDaoImpl implements LivingDao {
    @Override
    public int insert(Living living) {
        int count = 0;
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "INSERT INTO Living (RNO,LSTYLE,CNAME,CSEX,CAGE,CID,CTEL,LCOMEDATE,LLEFTDATE,AMOUNT,RENT)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1, living.getRNO());
            pstmt.setString(2, living.getLStyle());
            pstmt.setString(3, living.getCName());
            pstmt.setString(4, living.getCSex());
            pstmt.setInt(5, living.getCAge());
            pstmt.setString(6, living.getCId());
            pstmt.setString(7, living.getCTel());
            pstmt.setString(8, living.getLComeDate());
            pstmt.setString(9, living.getLLEFTDATE());
            pstmt.setInt(10, living.getAmount());
            pstmt.setInt(11, living.getRent());

            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return count;
    }

    @Override
    public Living findByRno(String Rno) {
        Living living = null;
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT * FROM Living WHERE RNO = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1, Rno);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                living = new Living();
                living.setRNO(rs.getString("RNO"));
                living.setLStyle(rs.getString("LSTYLE"));
                living.setCName(rs.getString("CNAME"));
                living.setCSex(rs.getString("CSEX"));
                living.setCAge(rs.getInt("CAGE"));
                living.setCId(rs.getString("CID"));
                living.setCTel(rs.getString("CTEL"));
                living.setLComeDate(rs.getString("LCOMEDATE"));
                living.setLLEFTDATE(rs.getString("LLEFTDATE"));
                living.setAmount(rs.getInt("AMOUNT"));
                living.setRent(rs.getInt("RENT"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return living;
    }

    @Override
    public List<Living> findByName(String name) {
        List<Living> livings = new ArrayList<Living>();
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT *FROM Living WHERE CNAME LIKE ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1, name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Living living = new Living();
                //利用当前记录各字段值设置登记表实体属性
                living.setRNO(rs.getString("RNO"));
                living.setLStyle(rs.getString("LSTYLE"));
                living.setCName(rs.getString("CNAME"));
                living.setCSex(rs.getString("CSEX"));
                living.setCAge(rs.getInt("CAGE"));
                living.setCId(rs.getString("CID"));
                living.setCTel(rs.getString("CTEL"));
                living.setLComeDate(rs.getString("LCOMEDATE"));
                living.setLLEFTDATE(rs.getString("LLEFTDATE"));
                living.setAmount(rs.getInt("AMOUNT"));
                living.setRent(rs.getInt("RENT"));
                //将实体添加到登记表列表
                livings.add(living);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return livings;
    }
}
