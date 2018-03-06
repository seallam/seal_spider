package com.seal.spider.test.protocal;

/**
 * 功能：消息枚举常量
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 14:18
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public enum MessageType {

    SERVICE_REQ((byte) 0), SERVICE_RESP((byte) 1), ONE_WAY((byte) 2), LOGIN_REQ(
            (byte) 3), LOGIN_RESP((byte) 4), HEARTBEAT_REQ((byte) 5), HEARTBEAT_RESP(
            (byte) 6);

    private byte value;

    private MessageType(byte value) {
        this.value = value;
    }

    public byte value() {
        return this.value;
    }
}
