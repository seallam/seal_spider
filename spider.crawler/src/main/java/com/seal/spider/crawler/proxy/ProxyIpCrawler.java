package com.seal.spider.crawler.proxy;

import com.seal.spider.commons.utils.RegexMatches;
import com.seal.spider.crawler.AbsCrawler;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

/**
 * 功能：爬取代理ip
 * 作者：Seal(Seal@lianj.com)
 * 日期：2017年06月24日 下午 04:48
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class ProxyIpCrawler extends AbsCrawler {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(60000)
            .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
            .addHeader("accept-encoding", "gzip, deflate, sdch, br")
            .addHeader("accept-language", "zh-CN,zh;q=0.8,en;q=0.6")
            .addHeader("cache-control", "no-cache")
            .addHeader("connection", "keep-alive")
            .addHeader("upgrade-insecure-requests", "1")
            .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36")
            .addHeader("postman-token", "5752b0dc-13ba-c460-2a21-a57086fee41b");

    private static String url = "http://www.xicidaili.com/nn";

    public void process(Page page) {
        Document doc = page.getHtml().getDocument();
        Elements ipList = doc.select("#ip_list tr");
        if (CollectionUtils.isNotEmpty(ipList)) {
            for (Element tr : ipList) {
                String ip = tr.select("td:eq(1)").text();
                if (StringUtils.isEmpty(ip)) {
                    continue;
                }
                if (!RegexMatches.ipMatches(ip)) {
                    logger.debug("IP地址:{}没通过校验", ip);
                    continue;
                }
//                logger.debug("ip:{}", ip);
                String port = tr.select("td:eq(2)").text();
                String area = tr.select("td:eq(3)").text();
                System.out.println(area);
                String http = tr.select("td:eq(5)").text();
                System.out.println(http);
            }
        }
    }

    public Site getSite() {
        return site;
    }

    protected void start(Integer start, Integer pageSize) {
        for (int i = start; i < start + pageSize; i ++) {

        }
        Spider.create(new ProxyIpCrawler()).addUrl(url).thread(5).run();
    }
}
