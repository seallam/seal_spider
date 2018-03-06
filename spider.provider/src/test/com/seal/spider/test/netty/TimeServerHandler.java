package com.seal.spider.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 功能：
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月01日 16:18
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "utf-8");
        String body = (String) msg;
        logger.debug("the time server receive order: {} ; the counter is : {}", body, ++counter);
        String curTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        curTime += System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(curTime.getBytes());
//        ctx.write(resp);
        ctx.writeAndFlush(resp);
    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
