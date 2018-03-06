package com.seal.spider.test.serial;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月02日 15:55
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
@ChannelHandler.Sharable
public class SubReqServerHandler extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        SubscribeReq req = (SubscribeReq) msg;
        if ("seal".equalsIgnoreCase(req.getUserName())) {
            logger.debug("service accept client subscribe req : [ {} ] ", req);
            ctx.writeAndFlush(resp(req.getSubReqID()));
        }
    }

    private SubscribeResp resp(int subReqID) {
        SubscribeResp resp = new SubscribeResp();
        resp.setSubReqID(subReqID);
        resp.setRespCode(0);
        resp.setDesc("netty book order succeed, 3 days later, sent to the address");
        return resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        logger.error(cause.getMessage(), cause);
        ctx.close();
    }
}
