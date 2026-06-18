package com.example.xosomienbac.model;

import java.util.List;

public class PrizeRow {
    String prize;
    List<String> values;

    public PrizeRow(
            String prize,
            List<String> values) {

        this.prize = prize;
        this.values = values;
    }

    public String getPrize() {
        return prize;
    }

    public List<String> getValues() {
        return values;
    }
}
