package com.Hotel.Java.Dao.DaoImpl;

import com.Hotel.Java.Dao.CustomerDao;
import com.Hotel.Java.Dbuilt.ConnectionDatebase;
import com.Hotel.Java.Entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public int insert(Customer customer) {
        int count = 0;
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "INSERT INTO Customer (CNAME,CSEX,CAGE,CID,CTEL) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,customer.getCName());
            pstmt.setString(2,customer.getCSex());
            pstmt.setInt(3,customer.getCAge());
            pstmt.setString(4,customer.getCId());
            pstmt.setString(5,customer.getCTel());

            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return count;
    }

    @Override
    public Customer CustomerbyName(String sname) {
        Customer customer = null;

        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT * FROM Customer WHERE CNAME = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,sname);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                customer = new Customer();
                //利用当前记录各字段值设置旅客实体属性
                customer.setCName(rs.getString("CNAME"));
                customer.setCSex(rs.getString("CSEX"));
                customer.setCAge(rs.getInt("CAGE"));
                customer.setCId(rs.getString("CID"));
                customer.setCTel(rs.getString("CTEL"));
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<Customer>();
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT * FROM Customer WHERE CNAME LIKE ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,name+"%");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Customer customer = new Customer();

                customer.setCName((rs.getString("CNAME")));
                customer.setCSex(rs.getString("CSEX"));
                customer.setCAge(rs.getInt("CAGE"));
                customer.setCId(rs.getString("CID"));
                customer.setCTel(rs.getString("CTEL"));
                //将实体添加到旅客列表
                customers.add(customer);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return customers;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Connection conn = ConnectionDatebase.getConnection();
        String strSQL = "SELECT * FROM Customer";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strSQL);
            while (rs.next()){
                Customer customer = new Customer();
                customer.setCName(rs.getString("CNAME"));
                customer.setCSex(rs.getString("CSEX"));
                customer.setCAge(rs.getInt("CAGE"));
                customer.setCId(rs.getString("CID"));
                customer.setCTel(rs.getString("CTEL"));
                customers.add(customer);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
        return customers;
    }
}
