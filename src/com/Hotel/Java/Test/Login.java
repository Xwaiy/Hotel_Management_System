package com.Hotel.Java.Test;

import com.Hotel.Java.Dbuilt.ConnectionDatebase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args){
        String user,password;
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入工号：");
        user = scanner.next();
        System.out.println("输入密码：");
        password = scanner.next();
        Connection conn = ConnectionDatebase.getConnection();
        try{
            String strSQL = "SELECT * FROM Administrator WHERE ANO = ? AND APASSWORD = ?";
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,user);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("恭喜，登录成功！");
            }else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDatebase.closeConnection(conn);
        }
    }
}
