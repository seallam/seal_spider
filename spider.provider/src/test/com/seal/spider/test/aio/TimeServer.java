package com.seal.spider.test.aio;

/**
 * 功能：AIO时间服务器服务端
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月01日 14:28
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);

        new Thread(timeServer, "AIO-asyncTimeServerHandler-001").start();
    }
}
