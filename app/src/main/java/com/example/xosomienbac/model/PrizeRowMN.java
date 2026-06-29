package com.example.xosomienbac.model;

import java.util.List;

public class PrizeRowMN {

    private String prize;

    private List<ProvincePrize> results;

    public PrizeRowMN(String prize,
                      List<ProvincePrize> results) {

        this.prize = prize;
        this.results = results;
    }

    public String getPrize() {
        return prize;
    }

    public List<ProvincePrize> getResults() {
        return results;
    }
}
