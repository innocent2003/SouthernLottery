package com.example.xosomienbac.crawler;
import com.example.xosomienbac.model.PrizeRow;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class XSMBCrawler {
    private String getTodayThu() {

        Calendar calendar = Calendar.getInstance();

        int dayOfWeek =
                calendar.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek) {

            case Calendar.MONDAY:
                return "2";

            case Calendar.TUESDAY:
                return "3";

            case Calendar.WEDNESDAY:
                return "4";

            case Calendar.THURSDAY:
                return "5";

            case Calendar.FRIDAY:
                return "6";

            case Calendar.SATURDAY:
                return "7";

            default:
                return "chu-nhat";
        }
    }
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

                        Elements spans = vGiai.select("span");

                        List<String> values = new ArrayList<>();

                        for (Element span : spans) {
                            values.add(span.text());
                        }

                        list.add(
                                new PrizeRow(
                                        tenGiai,
                                        values
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
