package com.Hotel.Java.Entity;

public class Administrator {
    private String ANO;
    private String AName;
    private String APassword;
    private String APosition;

    public String getANO() {
        return ANO;
    }

    public void setANO(String ANO) {
        this.ANO = ANO;
    }

    public String getAName() {
        return AName;
    }

    public void setAName(String AName) {
        this.AName = AName;
    }

    public String getAPassword() {
        return APassword;
    }

    public void setAPassword(String APassword) {
        this.APassword = APassword;
    }

    public String getAPosition() {
        return APosition;
    }

    public void setAPosition(String APosition) {
        this.APosition = APosition;
    }

    public Administrator() {
        super();
    }

    public Administrator(String ANO, String AName, String APassword, String APosition) {
        this.ANO = ANO;
        this.AName = AName;
        this.APassword = APassword;
        this.APosition = APosition;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "ANO=" + ANO +
                ", AName=" + AName +
                ", APassword=" + APassword +
                ", APosition=" + APosition +
                '}';
    }
}
