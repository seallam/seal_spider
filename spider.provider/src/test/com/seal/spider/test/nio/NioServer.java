package com.seal.spider.test.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 功能：nio服务端测试
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年02月07日 17:43
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class NioServer {
    private static Logger logger = LoggerFactory.getLogger(NioServer.class);

    public static void main(String[] args) {
//        method1();
        server();
    }

    public static void server() {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];
            while (true) {
                Socket clientSocket = serverSocket.accept();
                SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
                logger.debug("handling client at {}", clientAddress);
                InputStream in = clientSocket.getInputStream();
                while ((recvMsgSize = in.read(recvBuf)) != -1) {
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
    }

    public static void method1() {
        try (RandomAccessFile accessFile = new RandomAccessFile("./testHtml.txt", "rw")) {
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int read = fileChannel.read(buffer);
            System.out.println(read);

            while (read != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char)buffer.get());
                }

                buffer.compact();
                read = fileChannel.read(buffer);
            }
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
    }
}
