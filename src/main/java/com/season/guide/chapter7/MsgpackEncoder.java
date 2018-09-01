package com.season.guide.chapter7;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * Created by Administrator on 2018/9/1.
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {

    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        System.out.println("------编码");
        MessagePack msgPack = new MessagePack();
        byte[] raw = msgPack.write(o);
        byteBuf.writeBytes(raw);
    }
}
