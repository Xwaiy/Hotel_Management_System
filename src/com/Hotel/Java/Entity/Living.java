package com.Hotel.Java.Entity;

public class Living {
    private String RNO;
    private String LStyle;
    private String CName;
    private String CSex;
    private int CAge;
    private String CId;
    private String CTel;
    private int Rent;//租金
    private String LComeDate;
    private String LLEFTDATE;
    private int Amount;//定金

    public String getRNO() {
        return RNO;
    }

    public void setRNO(String RNO) {
        this.RNO = RNO;
    }

    public String getLStyle() {
        return LStyle;
    }

    public void setLStyle(String LStyle) {
        this.LStyle = LStyle;
    }

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

    public int getRent() {
        return Rent;
    }

    public void setRent(int rent) {
        Rent = rent;
    }

    public String getLComeDate() {
        return LComeDate;
    }

    public void setLComeDate(String LComeDate) {
        this.LComeDate = LComeDate;
    }

    public String getLLEFTDATE(){
        return LLEFTDATE;
    }
    public void setLLEFTDATE(String LLEFTDATE){
        this.LLEFTDATE = LLEFTDATE;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public Living() {
        super();
    }

    public Living(String RNO, String LStyle, String CName, String CSex, int CAge, String CId, String CTel, int rent, String LComeDate,String LLEFTDATE, int amount) {
        super();
        this.RNO = RNO;
        this.LStyle = LStyle;
        this.CName = CName;
        this.CSex = CSex;
        this.CAge = CAge;
        this.CId = CId;
        this.CTel = CTel;
        Rent = rent;
        this.LComeDate = LComeDate;
        this.LLEFTDATE = LLEFTDATE;
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Living{" +
                "RNO=" + RNO +
                ", LStyle=" + LStyle +
                ", CName=" + CName +
                ", CSex=" + CSex +
                ", CAge=" + CAge +
                ", CId=" + CId +
                ", CTel=" + CTel +
                ", Rent=" + Rent +
                ", LComeDate='" + LComeDate + '\'' +
                ", LLEFTDATE'"  + LLEFTDATE + '\'' +
                ", Amount=" + Amount +
                '}';
    }
}
