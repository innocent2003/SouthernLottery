package com.example.xosomienbac.model;

import java.util.List;

public class LotteryResultMN {
    private String id;
    private String region;
    private String date;
    private List<String> provinces;
    private List<PrizeRowMN> prizes;

    public LotteryResultMN() {
    }

    public LotteryResultMN(String id,
                           String region,
                           String date,
                           List<String> provinces,
                           List<PrizeRowMN> prizes) {

        this.id = id;
        this.region = region;
        this.date = date;
        this.provinces = provinces;
        this.prizes = prizes;
    }

    public String getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getDate() {
        return date;
    }

    public List<String> getProvinces() {
        return provinces;
    }

    public List<PrizeRowMN> getPrizes() {
        return prizes;
    }
}
