package com.seal.spider.test.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * 功能：UDP服务端启动类
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 9:26
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class ChineseProverbServer {

    public void run(int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProverbServerHandler());

            b.bind(port).sync().channel().closeFuture().await();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 9988;
        new ChineseProverbServer().run(port);
    }
}
