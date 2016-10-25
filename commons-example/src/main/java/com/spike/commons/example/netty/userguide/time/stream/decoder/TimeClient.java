package com.spike.commons.example.netty.userguide.time.stream.decoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.SocketAddress;

import org.apache.log4j.Logger;

import com.spike.commons.example.netty.util.NettyAppConstants;

/**
 * time service client
 */
public class TimeClient {
  private static final Logger LOG = Logger.getLogger(TimeClient.class);

  public static void main(String[] args) {
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      Bootstrap bootstrap = new Bootstrap();

      // not use the chain api methods
      bootstrap.group(workerGroup);
      bootstrap.channel(NioSocketChannel.class);
      bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
      bootstrap.handler(new ChannelInitializer<SocketChannel>() {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
          // 利用channel管道
          // 首先处理字节分片, 再直接读取
          ch.pipeline().addLast(new TimeDecoder(), new TimeClientHandler());
        }
      });

      SocketAddress address = NettyAppConstants.DEFAULT_ADDRESS;
      LOG.info("TimeClient连接到地址[" + address + "]，开始启动...");
      ChannelFuture future = bootstrap.connect(address).sync();

      // wait until the channel is closed
      future.channel().closeFuture().sync();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      workerGroup.shutdownGracefully();
    }
  }
}
