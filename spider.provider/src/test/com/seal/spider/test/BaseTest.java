package com.seal.spider.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 *
 * @author：Seal(Seal@lianj.com)
 *
 * 日期：2017年12月20日 16:34
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class BaseTest {

    public static void main(String[] args) {
        LocalThread localThread1 = new LocalThread();
        LocalThread localThread2 = new LocalThread();
        LocalThread.list.add("123");
        System.out.println(localThread1.list.size());
        System.out.println(localThread2.list.size());
    }

    private static class LocalThread extends Thread {
        public static List<String> list = new ArrayList<String>();
    }
}
