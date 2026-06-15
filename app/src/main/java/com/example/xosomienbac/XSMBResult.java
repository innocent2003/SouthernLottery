package com.example.xosomienbac;

public class XSMBResult {
    private String date;

    public String getGiaiDB() {
        return giaiDB;
    }

    public XSMBResult() {
    }

    public XSMBResult(String date, String giaiDB, String giaiNhat) {
        this.date = date;
        this.giaiDB = giaiDB;
        this.giaiNhat = giaiNhat;
    }

    public void setGiaiDB(String giaiDB) {
        this.giaiDB = giaiDB;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGiaiNhat() {
        return giaiNhat;
    }

    public void setGiaiNhat(String giaiNhat) {
        this.giaiNhat = giaiNhat;
    }

    private String giaiDB;
    private String giaiNhat;
}
