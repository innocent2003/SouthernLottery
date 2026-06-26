package com.example.xosomienbac.model;

import java.util.List;

public class RowData {

    private String rowClass;
    private List<String> cells;

    public RowData(
            String rowClass,
            List<String> cells) {

        this.rowClass = rowClass;
        this.cells = cells;
    }

    public String getRowClass() {
        return rowClass;
    }

    public List<String> getCells() {
        return cells;
    }
}
