package com.seal.spider.test.protocal;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;

/**
 * 功能：消息解码工具类
 * 作者：Seal(Seal@lianj.com)
 * <p>
 * 日期：2018年03月06日 11:59
 * 版权所有：广东联结网络技术有限公司 版权所有(C) 2016-2018
 */
public class NettyMarshallingDecoder extends MarshallingDecoder {

//    private final Unmarshaller unmarshaller;

    public NettyMarshallingDecoder(UnmarshallerProvider provider) {
        super(provider);
    }

    public NettyMarshallingDecoder(UnmarshallerProvider provider, int maxObjectSize) {
        super(provider, maxObjectSize);
    }

//    protected Object decode(ByteBuf in) throws IOException, ClassNotFoundException {
//        int objectSize = in.readInt();
//        ByteBuf buf = in.slice(in.readerIndex(), objectSize);
//        ByteInput input = new ChannelBufferByteInput(buf);
//        try {
//            unmarshaller.start(input);
//            Object obj = unmarshaller.readObject();
//            unmarshaller.finish();
//            in.readerIndex(in.readerIndex() + objectSize);
//            return obj;
//        } finally {
//            unmarshaller.close();
//        }
//    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        return super.decode(ctx, in);
    }
}
