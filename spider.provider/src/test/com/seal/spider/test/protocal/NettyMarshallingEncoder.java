package com.seal.spider.test.protocal;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

/**
 * 功能：netty消息编码工具类
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 11:35
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class NettyMarshallingEncoder extends MarshallingEncoder {

    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
//    private Marshaller marshaller;

    public NettyMarshallingEncoder(MarshallerProvider provider) {
        super(provider);
    }

//    protected void encode(Object msg, ByteBuf out) throws IOException {
//        try {
//            int lengthPos = out.writerIndex();
//            out.writeBytes(LENGTH_PLACEHOLDER);
//            ChannelBufferByteOutput output = new ChannelBufferByteOutput(out);
//            marshaller.start(output);
//            marshaller.writeObject(msg);
//            marshaller.finish();
//            out.setInt(lengthPos, out.writerIndex() - lengthPos - 4);
//        } finally {
//            marshaller.close();
//        }
//    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        super.encode(ctx, msg, out);
    }
}
