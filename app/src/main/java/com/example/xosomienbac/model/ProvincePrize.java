package com.example.xosomienbac.model;

import java.util.List;

public class ProvincePrize {

    private String province;

    private List<String> values;

    public ProvincePrize(String province,
                         List<String> values) {

        this.province = province;
        this.values = values;
    }

    public String getProvince() {
        return province;
    }

    public List<String> getValues() {
        return values;
    }
}
