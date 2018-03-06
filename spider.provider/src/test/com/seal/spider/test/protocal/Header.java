package com.seal.spider.test.protocal;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 功能：消息头
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 11:15
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public final class Header {

    private int crcCode = 0xabef0101;
    private int length;// 消息长度
    private long sessionId;// 会话id
    private byte type;// 消息类型
    private byte priority;// 消息优先级
    private Map<String, Object> attachment = Maps.newHashMap();

    public int getCrcCode() {
        return crcCode;
    }

    public void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public Map<String, Object> getAttachment() {
        return attachment;
    }

    public void setAttachment(Map<String, Object> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Header{" +
                "crcCode=" + crcCode +
                ", length=" + length +
                ", sessionId=" + sessionId +
                ", type=" + type +
                ", priority=" + priority +
                ", attachment=" + attachment +
                '}';
    }
}
