package com.season.guide.chapter4;

import com.season.guide.chapter3.TimeServerHandler;
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

    private final byte[] req;

    private int counter;

    public TimeClientHandler() {

        req = ("time" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        for (int i = 0; i < 100; i++) {
            msg = Unpooled.buffer(req.length);
            msg.writeBytes(req);

            ctx.writeAndFlush(msg);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] resp = new byte[buf.readableBytes()];
//        buf.readBytes(resp);
//        String body = new String(resp, "utf-8");
        String body = (String) msg;
        System.out.println("现在时间是：" + body + "; 计数为：" + (++counter));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warning("出错：" + cause.getMessage());
        ctx.close();
    }
}
