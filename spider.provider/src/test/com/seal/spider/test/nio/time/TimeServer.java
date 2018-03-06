package com.seal.spider.test.nio.time;

/**
 * 功能：nio时间服务器
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月01日 9:27
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
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
