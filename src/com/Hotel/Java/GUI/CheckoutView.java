package com.Hotel.Java.GUI;

import com.Hotel.Java.Common.FontStyle;
import com.Hotel.Java.Entity.Living;
import com.Hotel.Java.Service.Impl.LivingServiceImpl;
import com.Hotel.Java.Service.LivingService;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutView extends JPanel implements ActionListener {
    JTextField Cno,Name,Sex,Style,Charge,LeftTime;
    JButton search,checkout;
    FontStyle fontStyle = new FontStyle();
    private LivingService livingService;
    private Living living;
    SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss");
    public CheckoutView(){
        setLayout(null);
        JLabel cno = new JLabel("请输入房号:");
        cno.setBounds(90,90,150,35);
        cno.setFont(fontStyle.font);
        add(cno);
        Cno = new JTextField();
        Cno.setBounds(260,92,90,35);
        Cno.setFont(fontStyle.font);
        add(Cno);

        search = new JButton("查询");
        search.setBounds(580,90,95,35);
        search.setFont(fontStyle.font);
        add(search);
        //监听器——根据房号查询旅客信息
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Cno.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请填写房间号！","错误",JOptionPane.ERROR_MESSAGE);
                }else {
                    livingService = new LivingServiceImpl();
                    living = livingService.findByRno(Cno.getText().trim());
                    //显示旅客信息
                    if(living.equals("")){
                        JOptionPane.showMessageDialog(null,"该房间无人居住！","温馨提示",JOptionPane.WARNING_MESSAGE);
                    }else{
                        Name.setText(living.getCName());
                        Sex.setText(living.getCSex());
                        Style.setText(living.getLStyle());
                        Charge.setText(String.valueOf(living.getRent()));
                    }

                }
            }
        });

        JLabel name = new JLabel("旅客姓名:");
        name.setBounds(115,150,120,35);
        name.setFont(fontStyle.font);
        add(name);
        Name = new JTextField();
        Name.setBounds(255,150,120,35);
        Name.setFont(fontStyle.font);
        Name.setEditable(false);
        add(Name);

        JLabel sex = new JLabel("性别:");
        sex.setBounds(510,150,70,35);
        sex.setFont(fontStyle.font);
        add(sex);
        Sex = new JTextField();
        Sex.setBounds(580,150,70,35);
        Sex.setFont(fontStyle.font);
        Sex.setEditable(false);
        add(Sex);

        JLabel style = new JLabel("房型:");
        style.setBounds(150,210,70,35);
        style.setFont(fontStyle.font);
        add(style);
        Style = new JTextField();
        Style.setBounds(240,210,180,35);
        Style.setFont(fontStyle.font);
        Style.setEditable(false);
        add(Style);

        JLabel charge = new JLabel("收费:");
        charge.setBounds(510,210,70,35);
        charge.setFont(fontStyle.font);
        add(charge);
        Charge =new JTextField();
        Charge.setBounds(580,210,70,35);
        Charge.setFont(fontStyle.font);
        Charge.setEditable(false);
        add(Charge);

        JLabel lefttime = new JLabel("退房时间:");
        lefttime.setBounds(108,270,120,35);
        lefttime.setFont(fontStyle.font);
        add(lefttime);
        LeftTime = new JTextField();
        LeftTime.setBounds(243,273,350,30);
        LeftTime.setFont(fontStyle.font);
        LeftTime.setEditable(false);
        LeftTime.setOpaque(false);
        LeftTime.setBorder(null);

        LeftTime.addActionListener(new TimeActionListener());
        add(LeftTime);

        checkout = new JButton("退房");
        checkout.setBounds(420,350,95,35);
        checkout.setFont(fontStyle.font);
        add(checkout);
        checkout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //先判断是哪个按钮
        //查询按钮调用数据库语句查询信息并计算金钱

    }
    //动态显示时间(退房时间)
    private class TimeActionListener implements ActionListener {
        public TimeActionListener(){
            Timer time = new Timer(1000,this);
            time.start();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            LeftTime.setText(myfmt.format(new Date()).toString());
        }
    }
}
