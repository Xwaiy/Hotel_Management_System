package com.Hotel.Java.GUI;

import com.Hotel.Java.Common.FontStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomsView extends JPanel implements ActionListener {
    JPanel center;
    JTextField TimeText,occupy,free,maintain,dirty;
    JLabel Occupy,Free,Maintain,Dirty;
    FontStyle fontStyle = new FontStyle();
    JTable table;
    SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss");
    public RoomsView(){
        setLayout(null);
        //上面板
        JLabel tip = new JLabel("当前房间状态");
        tip.setFont(fontStyle.font);
        tip.setBounds(370,10,200,30);
        add(tip);
        //中面板
//        table从数据库中读数据利用Model建立
        center = new JPanel();
        String []title = {"房号","房间类型","租金","房间状态","定金","入住时间","退房时间"};
        Object[][]data={{ "001", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "002", "单人间", "240", "空闲","100","","" },
                { "003", "单人间", "240", "维修","100","","" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "005", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "003", "单人间", "240", "维修","100","","" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "005", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "003", "单人间", "240", "维修","100","","" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "005", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "005", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "005", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "005", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "005", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "004", "单人间", "240", "超时","100","2022-08-22","2022-08-24" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "123", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
                { "600", "单人间", "240", "已入住","100","2022-08-24","2022-08-27" },
        };
        table = new JTable(data,title);
        table.getTableHeader().setFont(fontStyle.Bold);
        table.getTableHeader().setReorderingAllowed(false);//表头不可拖动

        table.setFont(fontStyle.Song);
        table.setSelectionBackground(Color.cyan);
        table.setRowHeight(25);//行高
        table.setPreferredScrollableViewportSize(new Dimension(750, 525));
        center.setBounds(0,45,780,580);

        center.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        center.add(scrollPane);
        add(center);
        //右面板
        Occupy = new JLabel("占用",JLabel.CENTER);
        Occupy.setFont(fontStyle.While);
        Occupy.setBounds(780,274,50,30);
        Occupy.setOpaque(true);
        Occupy.setForeground(Color.WHITE);
        Occupy.setBackground(Color.red);
//      读取数据库信息更新房间数
        occupy = new JTextField();
        occupy.setFont(fontStyle.While);
        occupy.setBounds(850,274,50,30);
        occupy.setForeground(Color.RED);
        occupy.setEditable(false);
        occupy.setOpaque(false);
        occupy.setBorder(null);
        add(occupy);
        add(Occupy);

        Free = new JLabel("空闲",JLabel.CENTER);
        Free.setFont(fontStyle.While);
        Free.setBounds(780,314,50,30);
        Free.setOpaque(true);
        Free.setForeground(Color.WHITE);
        Free.setBackground(Color.GREEN);

        free = new JTextField();
        free.setFont(fontStyle.While);
        free.setBounds(850,314,50,30);
        free.setForeground(Color.RED);
        free.setEditable(false);
        free.setOpaque(false);
        free.setBorder(null);
        add(free);
        add(Free);

        Maintain = new JLabel("维修",JLabel.CENTER);
        Maintain.setFont(fontStyle.While);
        Maintain.setBounds(780,354,50,30);
        Maintain.setOpaque(true);
        Maintain.setForeground(Color.WHITE);
        Maintain.setBackground(Color.BLUE);

        maintain = new JTextField();
        maintain.setFont(fontStyle.While);
        maintain.setBounds(850,354,50,30);
        maintain.setForeground(Color.RED);
        maintain.setEditable(false);
        maintain.setOpaque(false);
        maintain.setBorder(null);
        add(maintain);
        add(Maintain);

        Dirty = new JLabel("未清洁",JLabel.CENTER);
        Dirty.setFont(fontStyle.While);
        Dirty.setBounds(780,394,70,30);
        Dirty.setOpaque(true);
        Dirty.setForeground(Color.WHITE);
        Dirty.setBackground(Color.DARK_GRAY);

        dirty = new JTextField();
        dirty.setFont(fontStyle.While);
        dirty.setBounds(870,394,50,30);
        dirty.setForeground(Color.RED);
        dirty.setEditable(false);
        dirty.setOpaque(false);
        dirty.setBorder(null);
        add(dirty);
        add(Dirty);

        TimeText = new JTextField();
        TimeText.setEditable(false);
        TimeText.setBorder(null);
        TimeText.setOpaque(false);
        TimeText.addActionListener(new TimeActionListener());
        TimeText.setBounds(780,574,150,20);
        add(TimeText);
//表格双击
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("双击表格");
                }
                return;
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private class TimeActionListener implements ActionListener {
        public TimeActionListener(){
            Timer time = new Timer(1000,this);
            time.start();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            TimeText.setText(myfmt.format(new Date()).toString());
        }
    }
}
