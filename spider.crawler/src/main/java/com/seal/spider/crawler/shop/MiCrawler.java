package com.seal.spider.crawler.shop;

import com.seal.spider.crawler.AbsCrawler;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

/**
 * 功能：爬取小米价格
 * 作者：Seal(Seal@lianj.com)
 * 日期：2017年06月24日 下午 12:04
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class MiCrawler extends AbsCrawler {
    private static Logger logger = LoggerFactory.getLogger(MiCrawler.class);

    private static String url = "https://item.mi.com/1171100001.html?cfrom=list";

//        Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//        Accept-Encoding:gzip, deflate, sdch, br
//        Accept-Language:zh-CN,zh;q=0.8,en;q=0.6
//        Cache-Control:max-age=0
//        Connection:keep-alive
//        Cookie:muuid=1486353097602_2635; xmuuid=XMGUEST-91C83FE0-EC1F-11E6-8AE0-AF9EAB5AC534; XM_2764706_UN=%E6%9E%97%E5%95%B8; euid=aio%2BFIgAmWHmTAaeOKl4fA%3D%3D; axmuid=2a1uHif0b5RcvxE%2BVqsIL2LYipQVdRFs3b8CMG00I30%3D; lastsource=logout.account.xiaomi.com; mstz=c78ea64770c6c191-1c76fbf2c4aeb4a6|%2F%2Fitem.mi.com%2F1171100001.html|1870928943.17|pcpid|https%3A%2F%2Flist.mi.com%2F23|http%3A%2F%2Flogout.account.xiaomi.com%2Flogout%3Fcallback%3Dhttps%253a%252f%252fwww.mi.com%252findex.html%7Cuserid%3D2764706%7Csid%3Dmi_eshop; mstuid=1486353101677_3570; xm_vistor=1486353101677_3570_1498292570477-1498292584443; msttime=https%3A%2F%2Fitem.mi.com%2F1171100001.html%3Fcfrom%3Dlist; xm_user_www_num=0
//        Host:item.mi.com
//        Referer:https://list.mi.com/23
//        Upgrade-Insecure-Requests:1
//        User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
            .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
            .addHeader("accept-encoding", "gzip, deflate, sdch, br")
            .addHeader("accept-language", "zh-CN,zh;q=0.8,en;q=0.6")
            .addHeader("cache-control", "no-cache")
            .addHeader("connection", "keep-alive")
            .addHeader("cookie", "muuid=1486353097602_2635; xmuuid=XMGUEST-91C83FE0-EC1F-11E6-8AE0-AF9EAB5AC534; XM_2764706_UN=%E6%9E%97%E5%95%B8; euid=aio%2BFIgAmWHmTAaeOKl4fA%3D%3D; axmuid=2a1uHif0b5RcvxE%2BVqsIL2LYipQVdRFs3b8CMG00I30%3D; lastsource=logout.account.xiaomi.com; mstz=c78ea64770c6c191-1c76fbf2c4aeb4a6|%2F%2Fitem.mi.com%2F1171100001.html|1870928943.17|pcpid|https%3A%2F%2Flist.mi.com%2F23|http%3A%2F%2Flogout.account.xiaomi.com%2Flogout%3Fcallback%3Dhttps%253a%252f%252fwww.mi.com%252findex.html%7Cuserid%3D2764706%7Csid%3Dmi_eshop; mstuid=1486353101677_3570; xm_vistor=1486353101677_3570_1498292570477-1498292584443; msttime=https%3A%2F%2Fitem.mi.com%2F1171100001.html%3Fcfrom%3Dlist; xm_user_www_num=0")
            .addHeader("host", "item.mi.com")
            .addHeader("referer", "https://list.mi.com/23")
            .addHeader("upgrade-insecure-requests", "1")
            .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");

    public static void main(String[] args) {
        Spider.create(new MiCrawler()).addUrl(url).thread(5).run();
    }

    public void process(Page page) {
        Document doc = page.getHtml().getDocument();
        Elements goodsDetail = doc.select("#goodsInfo-tmpl");
        Elements priceElements = goodsDetail.select(".goods-info-head-price");
        logger.debug(priceElements.text());
    }

    public Site getSite() {
        return site;
    }

    protected void start(Integer start, Integer pageSize) {

    }
}
