package com.spike.commons.example.netty.userguide.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import org.apache.log4j.Logger;

import com.spike.commons.example.netty.util.NettyAppConstants;

/**
 * <pre>
 * time service client
 * 
 * </pre>
 */
public class TimeClient {
  private static final Logger LOG = Logger.getLogger(TimeClient.class);

  public static void main(String[] args) {
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      // 客户端使用的启动器
      Bootstrap bootstrap = new Bootstrap();

      // 不使用链式调用语法
      bootstrap.group(workerGroup);
      bootstrap.channel(NioSocketChannel.class);
      bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
      bootstrap.handler(new ChannelInitializer<SocketChannel>() {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
          ch.pipeline().addLast(new TimeClientHandler());
        }
      });

      int port = NettyAppConstants.DEFAULT_PORT;
      LOG.info("TimeClient连接到端口[" + port + "]，开始启动...");
      ChannelFuture future = bootstrap.connect(NettyAppConstants.DEFAULT_ADDRESS).sync();

      // wait until the channel is closed
      future.channel().closeFuture().sync();

    } catch (Exception e) {

      LOG.error("TimeClient启动发生异常", e);

    } finally {

      workerGroup.shutdownGracefully();
    }
  }
}
