package com.seal.spider.test.protocal;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * 功能：netty服务端
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 15:25
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class NettyServer {

    public void bind() throws InterruptedException {
        // 配置服务端nio线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new NettyMessageDecoder(1024 * 1024, 4, 4));
                        pipeline.addLast(new NettyMessageEncoder());
                        pipeline.addLast("readTimeoutHandler", new ReadTimeoutHandler(50));
                        pipeline.addLast(new LoginAuthRespHandler());
                        pipeline.addLast("HeartBeatHandler", new HeartBeatRespHandler());
                    }
                });

        b.bind(NettyConstant.REMOTEIP, NettyConstant.PORT).sync();
        System.out.println("netty server start ok : " + NettyConstant.REMOTEIP + ":" + NettyConstant.PORT);
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer().bind();
    }
}
