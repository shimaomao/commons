package com.spike.commons.example.netty.userguide.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import org.apache.log4j.Logger;

import com.spike.commons.example.netty.util.NettyAppConstants;

/**
 * <pre>
 * a server discard all incoming message without any response
 * 忽略所有接收的消息，不产生响应
 * 
 * RFC 863 - Discard Protocol
 * </pre>
 */
public class DiscardServer {
  private static final Logger LOG = Logger.getLogger(DiscardServer.class);

  public static void main(String[] args) {

    // NioEventLoopGroup: 处理IO操作的多线程事件循环
    // 接收客户端连接
    EventLoopGroup masterGroup = new NioEventLoopGroup();
    // 处理客户端连接
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      // 启动Server的帮助类
      ServerBootstrap bootstrap = new ServerBootstrap();

      bootstrap.group(masterGroup, workerGroup);

      bootstrap.channel(NioServerSocketChannel.class);// 接收输入连接而实例化的channel
      // bootstrap.handler(new ChannelInitializer<ServerSocketChannel>() {
      // @Override
      // protected void initChannel(ServerSocketChannel ch) throws Exception { //
      // 为每个新接入的客户端创建新的handler
      // ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
      // }
      // });
      bootstrap.option(ChannelOption.SO_BACKLOG, 128);// 接收输入连接的channel配置项

      bootstrap.childHandler(// NioServerSocketChannel使用, 连接该监听端口的客户端使用
          new ChannelInitializer<SocketChannel>() {// 特殊的Handler,帮助用户配置新生成的channel
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG), new DiscardServerHandler());
            }
          });
      bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);// 接收的channel的配置项

      // 绑定端口，开始接收输入连接
      // 可以绑定不同的端口而多次调用bind()
      int port = NettyAppConstants.DEFAULT_PORT;
      LOG.info("DiscardServer绑定到端口[" + port + "]，开始启动...");
      ChannelFuture future = bootstrap.bind(port).sync();

      // 等待服务端关闭
      future.channel().closeFuture().sync();

    } catch (Exception e) {

      LOG.error("DiscardServer启动发生异常", e);

    } finally {

      workerGroup.shutdownGracefully();
      masterGroup.shutdownGracefully();
    }
  }
}
