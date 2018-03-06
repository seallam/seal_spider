package com.seal.spider.test.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * 功能：nio客户端测试
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年02月07日 17:41
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class NioClient {
    private static Logger logger = LoggerFactory.getLogger(NioClient.class);

    public static void main(String[] args) {
        client();
    }


    public static void client() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));

            if (socketChannel.finishConnect()) {
                int i = 0;
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    String info = String.format("I'm %d-th info from client", i);
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                    i++;
                }
            }
        } catch (IOException | InterruptedException e) {
            logger.error(e.toString(), e);
        }
    }
}
