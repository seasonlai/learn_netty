package com.season.guide.chapter9;

import com.season.guide.pojo.SubscribeReq;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Administrator on 2018/9/1.
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接成功..");
        for (int i = 0; i < 3; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端收到消息：" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private SubscribeReq subReq(int id) {
        SubscribeReq req = new SubscribeReq();
        req.setAddress("ShenZhen");
        req.setPhoneNumber("138xxxxxxxxx");
        req.setProductName("Netty Book For Marshalling");
        req.setSubReqID(id);
        req.setUserName("season");
        return req;
    }
}
