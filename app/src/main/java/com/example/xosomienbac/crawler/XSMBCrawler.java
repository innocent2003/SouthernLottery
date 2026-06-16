package com.example.xosomienbac.crawler;
import com.example.xosomienbac.model.PrizeRow;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
public class XSMBCrawler {
    public static void crawl(OnCrawlResultListener listener) {

        new Thread(() -> {

            try {

                String url =
                        "https://az24.vn/xsmb-sxmb-xo-so-mien-bac.html";

                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0")
                        .timeout(10000)
                        .get();

                Element table =
                        doc.selectFirst(
                                "table.kqmb.colgiai.extendable");

                List<PrizeRow> list =
                        new ArrayList<>();

                if (table != null) {

                    Elements rows = table.select("tr");

                    for (Element row : rows) {

                        Element txtGiai =
                                row.selectFirst(
                                        "td.txt-giai");

                        Element vGiai =
                                row.selectFirst(
                                        "td.v-giai");

                        if (txtGiai == null ||
                                vGiai == null) {
                            continue;
                        }

                        String tenGiai =
                                txtGiai.text();

                        Elements spans =
                                vGiai.select("span");

                        StringBuilder ketQua =
                                new StringBuilder();

                        for (Element span : spans) {

                            ketQua.append(
                                            span.text())
                                    .append(" ");
                        }

                        list.add(
                                new PrizeRow(
                                        tenGiai,
                                        ketQua.toString()
                                                .trim()
                                )
                        );
                    }
                }

                listener.onSuccess(list);

            } catch (Exception e) {

                listener.onError(e);
            }

        }).start();
    }
}
