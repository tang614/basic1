package com.tang.basic;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 网络客户端
 */
public class NettyClient {
    public static void main(String[] args) throws Exception{

        // 创建一个线程组
        EventLoopGroup group = new NioEventLoopGroup();

        // 创建客户端启动助手
        Bootstrap bootstrap = new Bootstrap();

        // 绑定相关数据
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {  // 设置一个通道初始化对象
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }
                });

        System.out.println("客户端已经准备好了...");

        // 连接服务器(异步非阻塞)
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999).sync();

        // 关闭连接
        channelFuture.channel().closeFuture();

    }
}
