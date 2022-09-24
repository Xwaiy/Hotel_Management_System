package com.Hotel.Java.Entity;

public class Rooms {
    private String RNO;
    private String RArea;
    private int Rent;
    private String RStyle;
    private String RState;
    private int RGross;
    private int RMargin;

    public String getRNO() {
        return RNO;
    }

    public void setRNO(String RNO) {
        this.RNO = RNO;
    }

    public String getRArea() {
        return RArea;
    }

    public void setRArea(String RArea) {
        this.RArea = RArea;
    }

    public int getRent() {
        return Rent;
    }

    public void setRent(int rent) {
        Rent = rent;
    }

    public String getRStyle() {
        return RStyle;
    }

    public void setRStyle(String RStyle) {
        this.RStyle = RStyle;
    }

    public String getRState() {
        return RState;
    }

    public void setRState(String RState) {
        this.RState = RState;
    }

    public int getRGross() {
        return RGross;
    }

    public void setRGross(int RGross) {
        this.RGross = RGross;
    }

    public int getRMargin() {
        return RMargin;
    }

    public void setRMargin(int RMargin) {
        this.RMargin = RMargin;
    }

    public Rooms() {
        super();
    }

    public Rooms(String RNO, String RArea, int rent, String RStyle, String RState, int RGross, int RMargin) {
        this.RNO = RNO;
        this.RArea = RArea;
        Rent = rent;
        this.RStyle = RStyle;
        this.RState = RState;
        this.RGross = RGross;
        this.RMargin = RMargin;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "RNO='" + RNO + '\'' +
                ", RArea='" + RArea + '\'' +
                ", Rent=" + Rent +
                ", RStyle='" + RStyle + '\'' +
                ", RState='" + RState + '\'' +
                ", RGross=" + RGross +
                ", RMargin=" + RMargin +
                '}';
    }
}
