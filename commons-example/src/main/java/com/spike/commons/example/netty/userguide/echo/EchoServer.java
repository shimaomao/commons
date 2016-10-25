package com.spike.commons.example.netty.userguide.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.apache.log4j.Logger;

import com.spike.commons.example.netty.userguide.discard.DiscardServer;
import com.spike.commons.example.netty.userguide.discard.DiscardServerHandler;
import com.spike.commons.example.netty.util.NettyAppConstants;

/**
 * <pre>
 * an echo server
 * 
 * 
 * RFC 862 - Echo Protocol
 * </pre>
 * @see DiscardServer
 */
public class EchoServer {
  private static final Logger LOG = Logger.getLogger(EchoServer.class);

  public static void main(String[] args) {

    // NioEventLoopGroup: 处理IO操作的多线程事件循环
    // 接收客户端连接
    EventLoopGroup masterGroup = new NioEventLoopGroup();
    // 处理客户端连接
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      // 启动Server的帮助类
      ServerBootstrap bootstrap = new ServerBootstrap();

      bootstrap//
          .group(masterGroup, workerGroup)//
          .channel(NioServerSocketChannel.class)// 接收输入连接而实例化的channel
          .childHandler(// 接收channel的handler
            // 特殊的Handler,帮助用户配置新生成的channel
            new ChannelInitializer<SocketChannel>() {
              @Override
              protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new DiscardServerHandler());
              }
            })//
          .option(ChannelOption.SO_BACKLOG, 128)// 接收输入连接的channel配置项
          .childOption(ChannelOption.SO_KEEPALIVE, true)// 接收的channel的配置项
      ;

      // 绑定端口，开始接收输入连接
      // 可以绑定不同的端口而多次调用bind()
      int port = NettyAppConstants.DEFAULT_PORT;
      LOG.info("EchoServer绑定到端口[" + port + "]，开始启动...");
      ChannelFuture future = bootstrap.bind(port).sync();

      // 等待服务端关闭
      future.channel().closeFuture().sync();

    } catch (Exception e) {

      LOG.error("EchoServer启动发生异常", e);

    } finally {

      workerGroup.shutdownGracefully();
      masterGroup.shutdownGracefully();
    }
  }

}
