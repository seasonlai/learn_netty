package com.season.guide.chapter7;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * Created by Administrator on 2018/9/1.
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("------解码");
        byte[] array;
        int len = byteBuf.readableBytes();
        array = new byte[len];
        byteBuf.getBytes(byteBuf.readerIndex(),array,0,array.length);
        MessagePack pack = new MessagePack();
        list.add(pack.read(array));
    }
}
