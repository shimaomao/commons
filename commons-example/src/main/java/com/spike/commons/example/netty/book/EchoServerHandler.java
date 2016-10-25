package com.spike.commons.example.netty.book;

import org.apache.log4j.Logger;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandler.Sharable;

/**
 * EchoServer's handler
 * @author zhoujiagen
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
  private static final Logger logger = Logger.getLogger(EchoServerHandler.class);

  @Override
  public void channelRead(ChannelHandlerContext context, Object messge) {
    logger.info("Server received: " + messge.toString());

    // echo back
    context.write(messge);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext context) {
    context.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
    logger.error("an exception caught", cause);

    context.close();
  }
}
