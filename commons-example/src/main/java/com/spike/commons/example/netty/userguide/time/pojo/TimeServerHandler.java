package com.spike.commons.example.netty.userguide.time.pojo;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.apache.log4j.Logger;

/**
 * TimeServer handler
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

  private static final Logger LOG = Logger.getLogger(TimeServerHandler.class);

  /**
   * <pre>
   * send message without receiving any requests, close connection once message is sent
   * 在未接收到消息前发送消息，一旦消息发送关闭连接
   * 
   * 连接一旦建立时触发
   * </pre>
   */
  @Override
  public void channelActive(final ChannelHandlerContext context) throws Exception {
    // ByteBuf bb = context.alloc().buffer(4);// for 32 bit integer
    // bb.writeInt((int) (System.currentTimeMillis() / 1000L +
    // 2208988800L));
    // final ChannelFuture channelFuture = context.writeAndFlush(bb);

    // 直接使用pojo写出
    UnixTime pojo = new UnixTime();
    LOG.info("连接建立时，写输出：" + pojo.toString());
    final ChannelFuture channelFuture = context.writeAndFlush(pojo);

    channelFuture.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) throws Exception {
        assert channelFuture == future;
        context.close();
      }
    });

  }

  /**
   * <pre>
   * occurs when exception raised by Netty due to IO error, or
   * due to handler's operation when processing events
   * 
   * 在Netty抛出IO异常或者handler处理事件操作中抛出异常时触发
   * 
   * </pre>
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
    // 记录日志
    if (cause != null) {
      // cause.printStackTrace();
      LOG.error(cause);
    }

    // 关闭channel
    LOG.info("关闭链接...");
    context.close();

    // 其他处理方式：根据异常类型处理，在关闭连接前发送响应消息等
  }
}
