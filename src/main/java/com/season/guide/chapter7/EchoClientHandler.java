package com.season.guide.chapter7;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Administrator on 2018/8/31.
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    private int counter;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] userInfos = UserInfo();
        for (UserInfo userInfo : userInfos) {
            System.out.println("客户端发送信息：" + userInfo);
            ctx.write(userInfo);
        }
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端收到msgpack信息：" + msg);
//        ctx.write(msg);
    }

    private UserInfo[] UserInfo() {
        int count = 3;
        UserInfo[] userInfos = new UserInfo[count];
        for (int i = 0; i < count; i++) {
            UserInfo info = new UserInfo();
            info.buildUserId(i).buildUserName("ABCDEFG -----> " + i);
            userInfos[i] = info;
        }
        return userInfos;
    }

}
