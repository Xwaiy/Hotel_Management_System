package com.Hotel.Java.Dbuilt;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatebase {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Hotel";
    private static final String USER = "Xwaiy";
    private static final String PASSWORD = "XQM610";

    private ConnectionDatebase(){

    }
    public static Connection getConnection(){
        Connection con = null;

        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    public static void closeConnection(Connection con){
        if(con!=null){
            try{
                if(!con.isClosed()){
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args){
        Connection con = getConnection();
        if (con==null){
            JOptionPane.showMessageDialog(null,"连接数据库失败！","连接失败",JOptionPane.ERROR_MESSAGE);
        }
        closeConnection(con);
    }
}
