package com.tang.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 服务器端业务处理类（这样的handler写一个就够了吗？为什么图里都是多个。）
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // 读取数据事件
    // msg为服务器读取到客户端发来的数据
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ctx:" + ctx);
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println("客户端发来的数据是：" + byteBuf.toString(CharsetUtil.UTF_8));
    }

    // 数据读取完成事件
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("就是没钱。",CharsetUtil.UTF_8));
    }

    // 异常发生事件
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
