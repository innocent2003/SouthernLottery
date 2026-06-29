package com.example.xosomienbac.model;

import java.util.List;

public class ProvinceResult {
    private String province;
    private List<String> values;

    public ProvinceResult(String province, List<String> values) {
        this.province = province;
        this.values = values;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
