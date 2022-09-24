package com.Hotel.Java.GUI;

import com.Hotel.Java.GUI.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginView extends JFrame implements ActionListener {
    JFrame mainJFrame;
    JButton okbutton;
    JTextField username;
    JPasswordField password;
    JLabel Toptext;
    public void Login() {
        mainJFrame = new JFrame();//创建JFrame窗口对象
        //状态栏图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img3 = tk.getImage("D:/IDEA/src/Hotel_Management_System/img/background.png");
        mainJFrame.setIconImage(img3);
        // 实现背景
        ImageIcon img = new ImageIcon("D:/IDEA/src/Hotel_Management_System/img/logo.png");
        JLabel imglabel = new JLabel(img);
        imglabel.setSize(1046, 654);
        mainJFrame.getLayeredPane().add(imglabel,new Integer(Integer.MIN_VALUE));//设置面板为最底层

        mainJFrame.setTitle("酒店客房管理系统");
        mainJFrame.setSize(1046,654);
        mainJFrame.getContentPane().setBackground(Color.gray);
        mainJFrame.setLocation(200,100);
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJFrame.getContentPane().setLayout(null);
        //创建面板
        JPanel pnl = (JPanel)mainJFrame.getContentPane();
        pnl.setSize(1046,654);
        pnl.setOpaque(false);
        pnl.setLayout(null);

        username = new JTextField();
        password = new JPasswordField();
        username.setSize(180, 29);
        username.setLocation(444, 275);
        password.setSize(180, 29);
        password.setLocation(444, 315);

        Toptext = new JLabel("酒店客房管理系统登录");
        Toptext.setForeground(Color.yellow);
        Toptext.setSize(400, 180);
        Toptext.setLocation(395, 128);
        Toptext.setFont(new Font("", 1, 25));

        okbutton = new JButton("登录");
        okbutton.setSize(235, 38);
        okbutton.setLocation(403, 416);
        okbutton.setFont(new Font("BLOD", 1, 16));
        okbutton.setContentAreaFilled(false); // 设置按钮透明
        okbutton.addActionListener(this);

        pnl.add(username);
        pnl.add(password);
        pnl.add(okbutton);
        pnl.add(Toptext);
        mainJFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Name,Pwd;
        Name = username.getText();
        Pwd = String.valueOf(password.getPassword());
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载数据库驱动

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        try{
            //连接数据库
            Connection con = null;
            Statement sql;
            ResultSet rset;
            String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Hotel";
            con = DriverManager.getConnection(URL,"Xwaiy","XQM610");
            sql = con.createStatement();
            rset = sql.executeQuery("SELECT * FROM Administrator WHERE ANO = '"+Name+"' AND APASSWORD = '"+Pwd+"'");
            int q = 0;
            while (rset.next())
            {
                q++;
            }
            if(q>0)
            {
                //关闭原窗口
                mainJFrame.setVisible(false);
                new HomePage();
            }
            else
                JOptionPane.showMessageDialog(this,"账号或密码错误！","登录失败",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"连接数据库失败！","连接失败",JOptionPane.ERROR_MESSAGE);
        }
    }
}
