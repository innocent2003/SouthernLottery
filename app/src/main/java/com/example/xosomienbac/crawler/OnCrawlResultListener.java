package com.example.xosomienbac.crawler;

import com.example.xosomienbac.model.PrizeRow;

import java.util.List;

public interface OnCrawlResultListener {
    void onSuccess(List<PrizeRow> data);
    void onError(Exception e);
}
