package com.season.guide.chapter3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/8/31.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {


    private static Logger logger = Logger.getLogger(TimeServerHandler.class.getName());

    private final ByteBuf firstMessage;

    public TimeClientHandler() {

        byte[] req = "time".getBytes();
        this.firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] resp = new byte[buf.readableBytes()];
        buf.readBytes(resp);
        String body = new String(resp, "utf-8");
        System.out.println("现在时间是：" + body);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warning("出错：" + cause.getMessage());
        ctx.close();
    }
}
