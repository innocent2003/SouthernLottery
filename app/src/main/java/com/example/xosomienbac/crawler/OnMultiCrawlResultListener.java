package com.example.xosomienbac.crawler;

import com.example.xosomienbac.model.RowData;

import java.util.List;

public interface OnMultiCrawlResultListener {

    void onSuccess(List<RowData> data);

    void onError(Exception e);
}
