package com.seal.spider.test.nio.time;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月01日 9:24
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class TimeClient {
    private static Integer port = 8080;

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        new Thread(new TimeClientHandler("127.0.0.1", port), "TimeClient-001").start();
    }
}
