package com.spike.commons.example.netty.book;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import org.apache.log4j.Logger;

import com.spike.commons.example.netty.util.NettyAppConstants;

/**
 * REF Netty in Action MEAP v5
 * @author zhoujiagen
 */
public class EchoClient {
  private static final Logger logger = Logger.getLogger(EchoClient.class);

  public static void main(String[] args) {
    new EchoClient().start();
  }

  public void start() {
    EventLoopGroup group = new NioEventLoopGroup();

    Bootstrap bootstrap = new Bootstrap();

    ChannelHandler handler = new ChannelInitializer<Channel>() {
      @Override
      protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(new EchoClientHandler());
      }
    };

    bootstrap.group(group);
    bootstrap.channel(NioSocketChannel.class);
    bootstrap.remoteAddress(NettyAppConstants.DEFAULT_ADDRESS);
    bootstrap.handler(handler);

    try {
      ChannelFuture future = bootstrap.connect().sync();

      future.channel().closeFuture().sync();

    } catch (InterruptedException e) {
      logger.error("connect failed", e);
    } finally {
      try {
        group.shutdownGracefully().sync();
      } catch (InterruptedException e) {
        logger.error("shut down event loop group failed", e);
      }
    }

  }

}
