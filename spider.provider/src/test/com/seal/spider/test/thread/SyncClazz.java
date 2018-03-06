package com.seal.spider.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月05日 11:24
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class SyncClazz {
    private volatile boolean stop;

    public void stop() {
        stop = true;
    }

    public void a() {
        System.out.println("非同步方法");
    }

    public synchronized void b() {
        System.out.println("同步方法");
        while (!stop) {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("still running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
