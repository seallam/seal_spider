package com.seal.spider.test.thread;

import com.seal.spider.test.BaseTest;

import java.util.concurrent.TimeUnit;

/**
 * 功能：同步测试类
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月05日 11:20
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class SyncTest extends BaseTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1启动");
                SyncClazz a = new SyncClazz();
                System.out.println("线程1调用同步方法...");
                a.b();
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.stop();
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2启动");
                SyncClazz a = new SyncClazz();
                System.out.println("线程2调用非同步方法...");
                a.a();
            }
        }).start();
    }

}
