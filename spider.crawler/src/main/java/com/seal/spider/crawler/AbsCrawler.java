package com.seal.spider.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * 日期：2017年06月24日 下午 04:51
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public abstract class AbsCrawler implements PageProcessor {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected abstract void start(Integer start, Integer pageSize);
}
