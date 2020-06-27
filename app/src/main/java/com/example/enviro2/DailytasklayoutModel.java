package com.example.enviro2;

public class DailytasklayoutModel {

    private int dailytaskImage;
    private String dailytaskNo;
    private String dailytaskBody;
    private String dailytaskDate;

    public DailytasklayoutModel(int dailytaskImage, String dailytaskNo, String dailytaskBody, String dailytaskDate) {
        this.dailytaskImage = dailytaskImage;
        this.dailytaskNo = dailytaskNo;
        this.dailytaskBody = dailytaskBody;
        this.dailytaskDate = dailytaskDate;
    }

    public int getDailytaskImage() {
        return dailytaskImage;
    }

    public void setDailytaskImage(int dailytaskImage) {
        this.dailytaskImage = dailytaskImage;
    }

    public String getDailytaskNo() {
        return dailytaskNo;
    }

    public void setDailytaskNo(String dailytaskNo) {
        this.dailytaskNo = dailytaskNo;
    }

    public String getDailytaskBody() {
        return dailytaskBody;
    }

    public void setDailytaskBody(String dailytaskBody) {
        this.dailytaskBody = dailytaskBody;
    }

    public String getDailytaskDate() {
        return dailytaskDate;
    }

    public void setDailytaskDate(String dailytaskDate) {
        this.dailytaskDate = dailytaskDate;
    }
}
