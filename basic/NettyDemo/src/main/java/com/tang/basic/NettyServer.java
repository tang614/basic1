package com.tang.basic;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws Exception{

        // 创建一个线程组，接受客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 创建一个线程组，处理网络操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 创建服务器端启动助手来配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)        // 设置两个线程组
            .channel(NioServerSocketChannel.class)          // netty底层使用NIO的通道作为实现
            .option(ChannelOption.SO_BACKLOG,128)     // 设置线程队列中等待的个数
            .childOption(ChannelOption.SO_KEEPALIVE,true)   // 保持活跃连接状态
            .childHandler(new ChannelInitializer<SocketChannel>() { // 初始化一个通道（一个连接一个通道）
                public void initChannel(SocketChannel sc){
                    sc.pipeline().addLast(new NettyServerHandler()); // 一个通道一个pipline,里面是处理逻辑handler的集合
                }
            });

        // 服务器准备就绪
        System.out.println("服务器准备就绪...");

        ChannelFuture channelFuture = serverBootstrap.bind(9999).sync(); // 异步，绑定端口，非阻塞

        System.out.println("服务器以及开启...");

        // 关闭通道
        channelFuture.channel().closeFuture().sync(); // 异步

        // 关闭线程组
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
