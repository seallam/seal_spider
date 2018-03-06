package com.seal.spider.test.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 功能：UDP服务端启动类
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 9:29
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class ChineseProverbServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final String[] DICTIONARY = {"只要功夫深,铁柱磨成针", "旧时王谢堂前燕,飞入寻常百姓家",
    "洛阳亲友如相问,一片冰心在玉壶", "一寸光阴一寸金,寸金难买寸光阴", "老骥伏枥,志在千里.烈士暮年,壮心不已"};

    private String nextQuote() {
        int quoteId = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
        return DICTIONARY[quoteId];
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String req = packet.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        if ("谚语字典查询?".equals(req)) {
            ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语查询结果: " + nextQuote(), CharsetUtil.UTF_8), packet.sender()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
