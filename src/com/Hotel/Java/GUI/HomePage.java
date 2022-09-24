package com.Hotel.Java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    JTabbedPane jTabbedPane;
    CheckinView checkinview;
    CheckoutView checkoutView;
    RoomsView roomsView;
    GuestLivingView guestLivingView;
    Exit exit;
    JPanel pnl;

    public HomePage(){
        //创建窗口
        JFrame mainJFrame = new JFrame();
        mainJFrame.setTitle("欢迎使用酒店客房管理系统");
        mainJFrame.setBounds(200,30,1046,654);
        mainJFrame.setBackground(Color.lightGray);
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //状态栏图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("D:/IDEA/src/Hotel_Management_System/img/background.png");
        mainJFrame.setIconImage(img);

        jTabbedPane = new JTabbedPane();
        checkinview = new CheckinView();
        checkoutView = new CheckoutView();
        roomsView = new RoomsView();
        guestLivingView = new GuestLivingView();
        exit = new Exit();
        //容器
        Container container = mainJFrame.getContentPane();
        container.setBackground(Color.lightGray);
        container.setSize(1046,654);
        container.setLayout(null);

        jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
        jTabbedPane.addTab("入住登记",checkinview);
        jTabbedPane.addTab("退房结账",checkoutView);
        jTabbedPane.addTab("房间状态",roomsView);
        jTabbedPane.addTab("查询客人",guestLivingView);
        jTabbedPane.addTab("退出",exit);
        jTabbedPane.setFont(new Font("宋体",Font.BOLD,15));
        jTabbedPane.setBounds(-3,-2,mainJFrame.getWidth(),mainJFrame.getHeight());
        validate();

        container.add(jTabbedPane);
        mainJFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[]args)
    {
        HomePage homePage = new HomePage();
    }
}
