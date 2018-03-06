package com.seal.spider.test.aio;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月01日 14:50
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class TimeClient {

    private static int port = 8080;

    public static void main(String[] args) {
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClient-001").start();
    }
}
