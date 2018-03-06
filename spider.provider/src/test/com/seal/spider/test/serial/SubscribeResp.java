package com.seal.spider.test.serial;

import java.io.Serializable;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月02日 15:50
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class SubscribeResp implements Serializable {

    private static final long serialVersionUID = 1L;

    private int subReqID;

    private int respCode;

    private String desc;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SubscribeResp{" +
                "subReqID=" + subReqID +
                ", respCode=" + respCode +
                ", desc='" + desc + '\'' +
                '}';
    }
}
