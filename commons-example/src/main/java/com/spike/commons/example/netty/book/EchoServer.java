package com.spike.commons.example.netty.book;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.apache.log4j.Logger;

import com.spike.commons.example.netty.util.NettyAppConstants;

/**
 * REF Netty in Action MEAP v5
 * @author zhoujiagen
 */
public class EchoServer {
  private static final Logger logger = Logger.getLogger(EchoServer.class);

  public static void main(String[] args) {
    new EchoServer().start();
  }

  public void start() {
    // NIO transport
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    ServerBootstrap bootstrap = new ServerBootstrap();

    ChannelHandler channelHandler = new ChannelInitializer<Channel>() {
      @Override
      protected void initChannel(Channel ch) throws Exception {
        // add handler to channel pipeline
        ch.pipeline().addLast(new EchoServerHandler());
      }
    };

    // DO NOT use chain API
    bootstrap.group(eventLoopGroup);
    bootstrap.channel(NioServerSocketChannel.class);
    bootstrap.localAddress(NettyAppConstants.DEFAULT_ADDRESS);
    bootstrap.childHandler(channelHandler);

    try {
      ChannelFuture channelFuture = bootstrap.bind().sync();
      logger.info(EchoServer.class.getName() + " started and listen on "
          + channelFuture.channel().localAddress());

      channelFuture.channel().closeFuture().sync();

    } catch (InterruptedException e) {
      logger.error("bind failed", e);
    } finally {
      try {
        eventLoopGroup.shutdownGracefully().sync();
      } catch (InterruptedException e) {
        logger.error("shut down event loop group failed", e);
      }
    }

  }
}
