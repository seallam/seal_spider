package com.seal.spider.commons.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能：正则校验工具
 * 作者：Seal(Seal@lianj.com)
 * 日期：2017年06月26日 上午 10:38
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class RegexMatches {

    public static boolean matches(String pattern, String str) {
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    public static boolean ipMatches(String ip) {
        String pattern = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
        return matches(pattern, ip);
    }
}
