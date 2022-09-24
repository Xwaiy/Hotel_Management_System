package com.Hotel.Java.Entity;

public class Customer {
    private String CName;
    private String CSex;
    private int CAge;
    private String CId;
    private String CTel;

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCSex() {
        return CSex;
    }

    public void setCSex(String CSex) {
        this.CSex = CSex;
    }

    public int getCAge() {
        return CAge;
    }

    public void setCAge(int CAge) {
        this.CAge = CAge;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCTel() {
        return CTel;
    }

    public void setCTel(String CTel) {
        this.CTel = CTel;
    }

    public Customer() {
    }

    public Customer(String CName, String CSex, int CAge, String CId, String CTel) {
        super();
        this.CName = CName;
        this.CSex = CSex;
        this.CAge = CAge;
        this.CId = CId;
        this.CTel = CTel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CName='" + CName + '\'' +
                ", CSex='" + CSex + '\'' +
                ", CAge=" + CAge +
                ", CId='" + CId + '\'' +
                ", CTel='" + CTel + '\'' +
                '}';
    }
}