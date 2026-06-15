package com.example.xosomienbac.model;

public class PrizeRow {
    String prize;
    String value;

    public PrizeRow(String prize, String value) {
        this.prize = prize;
        this.value = value;
    }

    public String getPrize() {
        return prize;
    }

    public String getValue() {
        return value;
    }
}
