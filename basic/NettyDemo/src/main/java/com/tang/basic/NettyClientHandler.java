package com.tang.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 客户端业务处理类
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    // 通道就绪事件
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ctx:" + ctx);       // 这里看看上下文对象是啥
        ctx.writeAndFlush(Unpooled.copiedBuffer("老板，还钱吧",CharsetUtil.UTF_8));   // 给客户端写数据
    }

    // 接受客户端的消息
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器发来的数据是：" + byteBuf.toString(CharsetUtil.UTF_8));
    }

    // 可写可不写，不重写就调用父类的方法
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
