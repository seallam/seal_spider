package com.seal.spider.test.protocal;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 11:14
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class NettyMessage {

    private Header header;// 消息头
    private Object body;// 消息体

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "NettyMessage{" +
                "header=" + header +
                '}';
    }
}
