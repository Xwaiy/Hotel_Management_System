package com.Hotel.Java.GUI;

import com.Hotel.Java.Common.FontStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestLivingView extends JPanel implements ActionListener {
    JTextField roomCno,guestName;
    JButton Search;
    JTable table;
    JPanel jpl;
    FontStyle fontStyle = new FontStyle();
    public GuestLivingView(){
        setLayout(null);
        JLabel roomcno = new JLabel("请输入房号:");
        roomcno.setBounds(50,40,150,35);
        roomcno.setFont(fontStyle.font);
        add(roomcno);
        roomCno = new JTextField();
        roomCno.setBounds(200,42,90,35);
        roomCno.setFont(fontStyle.font);
        add(roomCno);

        JLabel or = new JLabel("或");
        or.setBounds(320,40,150,35);
        or.setFont(fontStyle.font);
        add(or);

        JLabel guestname = new JLabel("请输入姓名:");
        guestname.setBounds(370,40,150,35);
        guestname.setFont(fontStyle.font);
        add(guestname);
        guestName = new JTextField();
        guestName.setBounds(520,42,90,35);
        guestName.setFont(fontStyle.font);
        add(guestName);

        Search = new JButton("查询");
        Search.setBounds(730,40,95,35);
        Search.setFont(fontStyle.font);
        add(Search);
        Search.addActionListener(this);

        jpl = new JPanel();
        String []title = {"房号","房型","旅客姓名","性别","电话","入住时间"};
        Object[][]data = {{"001","单人间","Xwaiy","男","13435485749","2022-08-29"}};
        table = new JTable(data,title);
        table.getTableHeader().setFont(fontStyle.Bold);
        table.getTableHeader().setReorderingAllowed(false);//表头不可拖动

        table.setFont(fontStyle.Song);
        table.setSelectionBackground(Color.cyan);
        table.setRowHeight(25);//行高
        table.setPreferredScrollableViewportSize(new Dimension(750, 425));
        jpl.setBounds(50,100,780,480);

        jpl.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        jpl.add(scrollPane);
        add(jpl);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
