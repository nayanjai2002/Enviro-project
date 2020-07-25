package com.example.enviro2;

public class AlltaskLayoutModel {

    private int alltaskImage;
    private String alltaskNo;
    private String alltaskBody;
    private String alltaskDate;

    public AlltaskLayoutModel(int alltaskImage, String alltaskNo, String alltaskBody, String alltaskDate) {
        this.alltaskImage = alltaskImage;
        this.alltaskNo = alltaskNo;
        this.alltaskBody = alltaskBody;
        this.alltaskDate = alltaskDate;
    }


    public int getAlltaskImage() {
        return alltaskImage;
    }

    public void setAlltaskImage(int alltaskImage) {
        this.alltaskImage = alltaskImage;
    }

    public String getAlltaskNo() {
        return alltaskNo;
    }

    public void setAlltaskNo(String alltaskNo) {
        this.alltaskNo = alltaskNo;
    }

    public String getAlltaskBody() {
        return alltaskBody;
    }

    public void setAlltaskBody(String alltaskBody) {
        this.alltaskBody = alltaskBody;
    }

    public String getAlltaskDate() {
        return alltaskDate;
    }

    public void setAlltaskDate(String alltaskDate) {
        this.alltaskDate = alltaskDate;
    }
}
