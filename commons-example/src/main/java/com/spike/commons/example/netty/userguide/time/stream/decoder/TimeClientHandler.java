package com.spike.commons.example.netty.userguide.time.stream.decoder;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * time service client handler
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

  /**
   * occurs when new data is received from a client
   */
  @Override
  public void channelRead(ChannelHandlerContext context, Object message) {
    ByteBuf bb = (ByteBuf) message;

    try {
      long currentTimeMillis = (bb.readUnsignedInt() - 2208988800L) * 1000L;
      System.out.println(new Date(currentTimeMillis));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      bb.release();
    }

  }

  /**
   * occurs when exception raised by Netty due to IO error, or<br/>
   * due to handler's operation when processing events
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
    cause.printStackTrace();

    context.close();
  }
}
