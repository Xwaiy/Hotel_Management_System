package com.Hotel.Java.GUI;

import com.Hotel.Java.Common.FontStyle;
import com.Hotel.Java.Dbuilt.ConnectionDatebase;
import com.Hotel.Java.Entity.Administrator;
import com.Hotel.Java.Entity.Living;
import com.Hotel.Java.Entity.Rooms;
import com.Hotel.Java.Service.AdministratorService;
import com.Hotel.Java.Service.Impl.LivingServiceImpl;
import com.Hotel.Java.Service.Impl.RoomsServiceImpl;
import com.Hotel.Java.Service.LivingService;
import com.Hotel.Java.Service.RoomsService;

import javax.sql.rowset.CachedRowSet;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class CheckinView extends JPanel implements ActionListener {

    JTextField Name, Id, Age, Tel, LivingTime,LeftTime,Amount;
    JComboBox<String> Rno, Style;
    String[] styledata = new String[]{"单人间", "标准间", "高级标间", "三人间", "豪华套房"};
    String styleselect;
    JRadioButton Man, Woman;
    JButton checkin;
    FontStyle fontStyle = new FontStyle();
    private LivingService livingService;
    private Living living;
    private RoomsService roomsService;
    private Rooms rooms;
    private int Rent;
    SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd");

    public CheckinView() {
        setLayout(null);
        JLabel name = new JLabel("姓名:");
        name.setBounds(160, 90, 70, 35);
        name.setFont(fontStyle.font);
        add(name);
        Name = new JTextField();
        Name.setBounds(245, 94, 120, 30);
        Name.setFont(fontStyle.font);
        add(Name);

        JLabel Sex = new JLabel("性别:");
        Sex.setBounds(580, 90, 70, 35);
        Sex.setFont(fontStyle.font);
        add(Sex);
        Man = new JRadioButton("男",true);
        Woman = new JRadioButton("女");
        Man.setBounds(665, 93, 55, 35);
        Man.setFont(fontStyle.font);
        Woman.setBounds(740, 93, 55, 35);
        Woman.setFont(fontStyle.font);
        ButtonGroup group = new ButtonGroup();
        group.add(Man);
        group.add(Woman);
        add(Man);
        add(Woman);

        JLabel id = new JLabel("身份证号:");
        id.setBounds(108, 150, 120, 35);
        id.setFont(fontStyle.font);
        add(id);
        Id = new JTextField();
        Id.setBounds(243, 150, 260, 30);
        Id.setFont(fontStyle.font);
        add(Id);

        JLabel age = new JLabel("年龄:");
        age.setBounds(580, 150, 70, 35);
        age.setFont(fontStyle.font);
        add(age);
        Age = new JTextField();
        Age.setBounds(665, 150, 50, 35);
        Age.setFont(fontStyle.font);
        add(Age);

        JLabel tel = new JLabel("电话:");
        tel.setBounds(160, 210, 70, 35);
        tel.setFont(fontStyle.font);
        add(tel);
        Tel = new JTextField();
        Tel.setBounds(245, 210, 180, 30);
        Tel.setFont(fontStyle.font);
        add(Tel);

        /*
            根据房型去查询“空闲"状态的房间号显示出来,还有根据”房型“获取房子租金
            1、先获取房型————> 监听器
            2、sql语句根据"房型"查询房间号————> LivingDao(.清空房号下拉框的原始数据；重新设置后续下拉框的原始数据。
            3、返回一集合，并显示在JComboBox中
         */
        JLabel style = new JLabel("房型:");
        style.setBounds(160, 270, 70, 35);
        style.setFont(fontStyle.font);
        add(style);
        Style = new JComboBox<String>(styledata);
        Style.setBounds(245, 270, 180, 35);
        Style.setFont(fontStyle.font);
        Style.setSelectedIndex(-1);
        add(Style);
        Style.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Rno.removeAllItems();
                    //根据房型更换空闲房号
                    rooms = new Rooms();
                    styleselect = e.getItem().toString();
                    roomsService = new RoomsServiceImpl();

                        if(roomsService.findByStyle(styleselect).size()>0){
                            for(Rooms rooms1:roomsService.findByStyle(styleselect)){
                                Rno.addItem(rooms1.getRNO());
                                Rent = rooms1.getRent();
                            }
                        }else
                            JOptionPane.showMessageDialog(null,"该房型已住满","无房提醒",JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        JLabel rno = new JLabel("房号:");
        rno.setBounds(580, 210, 70, 35);
        rno.setFont(fontStyle.font);
        add(rno);
        Rno = new JComboBox<>();
        Rno.setBounds(665, 210, 150, 35);
        Rno.setFont(fontStyle.font);
        add(Rno);

        JLabel amount = new JLabel("定金:");
        amount.setBounds(580, 270, 70, 35);
        amount.setFont(fontStyle.font);
        add(amount);
        Amount = new JTextField("150");
        Amount.setBounds(665, 270, 95, 35);
        Amount.setFont(fontStyle.font);
        Amount.setEditable(false);
        add(Amount);

        JLabel livingtime = new JLabel("入住时间:");
        livingtime.setBounds(108, 330, 120, 35);
        livingtime.setFont(fontStyle.font);
        add(livingtime);
        LivingTime = new JTextField();
        LivingTime.setBounds(243, 332, 180, 30);
        LivingTime.setFont(fontStyle.font);
        LivingTime.setEditable(false);
        LivingTime.setOpaque(false);
        LivingTime.setBorder(null);
        LivingTime.addActionListener(new TimeActionListener());
        add(LivingTime);

        JLabel lefttime = new JLabel("预离时间:");
        lefttime.setBounds(530, 330, 120, 35);
        lefttime.setFont(fontStyle.font);
        add(lefttime);
        LeftTime = new JTextField();
        LeftTime.setBounds(665, 332, 180, 30);
        LeftTime.setFont(fontStyle.font);
        add(LeftTime);

        checkin = new JButton("登记");
        checkin.setBounds(420, 440, 95, 35);
        checkin.setFont(fontStyle.font);
        add(checkin);
        checkin.addActionListener(this);

    }

    //登记按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Name.getText().equals("")||Age.getText().equals("")||Id.getText().equals("")
                ||Tel.getText().equals("")||LeftTime.getText().equals("")){
            JOptionPane.showMessageDialog(null,"信息未填写完整或时间信息填写错误，不能登记入住！",
                    "错误",JOptionPane.ERROR_MESSAGE);
        }else {
            try{
                //入住登记实体
                living = new Living();
                living.setRNO(Rno.getSelectedItem().toString().trim());
                living.setLStyle(Style.getSelectedItem().toString().trim());
                living.setCName(Name.getText().trim());
                living.setCSex(selectSex(Man,Woman).trim());
                living.setCAge(Integer.parseInt(Age.getText()));
                living.setCId(Id.getText().trim());
                living.setCTel(Tel.getText().trim());
                living.setLComeDate(LivingTime.getText().trim());
                living.setLLEFTDATE(LeftTime.getText().trim());
                living.setAmount(Integer.parseInt(Amount.getText().toString().trim()));
                living.setRent(Rent);
                //创建入住登记服务对象
                livingService = new LivingServiceImpl();
                //登记
                int count = livingService.insert(living);
                if(count>0){
                    JOptionPane.showMessageDialog(null,"入住登记成功，您的房号为:"+Rno.getSelectedItem().toString(),"入住登记",JOptionPane.INFORMATION_MESSAGE);
                    Name.setText("");
                    Age.setText("");
                    Id.setText("");
                    Tel.setText("");
                    Style.setSelectedIndex(-1);
                    Rno.setSelectedIndex(-1);
                    LeftTime.setText("");
                }else {
                    JOptionPane.showMessageDialog(null,"入住登记失败","入住登记",JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                throw new RuntimeException(ex);
            } catch (HeadlessException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    //动态显示时间(入住时间)
    private class TimeActionListener implements ActionListener {
        public TimeActionListener() {
            Timer time = new Timer(1000, this);
            time.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LivingTime.setText(myfmt.format(new Date()).toString());
        }
    }

    //获取选中哪一个性别
    public String selectSex(JRadioButton Man,JRadioButton Woman){
        if(Man.isSelected()){
            return Man.getText();
        }else
            return Woman.getText();
    }
}
