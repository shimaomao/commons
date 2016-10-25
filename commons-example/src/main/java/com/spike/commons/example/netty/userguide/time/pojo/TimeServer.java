package com.spike.commons.example.netty.userguide.time.pojo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.apache.log4j.Logger;

import com.spike.commons.example.netty.util.NettyAppConstants;

/**
 * a time server
 */
public class TimeServer {
  private static final Logger LOG = Logger.getLogger(TimeServer.class);

  public static void main(String[] args) {
    EventLoopGroup masterGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap bootstrap = new ServerBootstrap();

      bootstrap
          //
          .group(masterGroup, workerGroup)
          //
          .channel(NioServerSocketChannel.class)
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
              // 使用channel管道，先添加encoder，
              ch.pipeline().addLast(new TimeEncoder(), new TimeServerHandler());
            }
          })//
          .option(ChannelOption.SO_BACKLOG, 128)//
          .childOption(ChannelOption.SO_KEEPALIVE, true);

      int port = NettyAppConstants.DEFAULT_PORT;
      LOG.info("TimeServer绑定到端口[" + port + "]，开始启动...");
      ChannelFuture future = bootstrap.bind(port).sync();

      future.channel().closeFuture().sync();

    } catch (Exception e) {

      LOG.error("TimeServer启动发生异常", e);

    } finally {

      LOG.info("关闭TimeServer...");
      workerGroup.shutdownGracefully();
      masterGroup.shutdownGracefully();
    }
  }

}
