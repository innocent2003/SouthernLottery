package com.example.xosomienbac.model;

import java.util.List;

public class MultiPrizeRow {
    private String prize;
    private List<ProvinceResult> results;

    public MultiPrizeRow(String prize, List<ProvinceResult> results) {
        this.prize = prize;
        this.results = results;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public List<ProvinceResult> getResults() {
        return results;
    }

    public void setResults(List<ProvinceResult> results) {
        this.results = results;
    }
}
