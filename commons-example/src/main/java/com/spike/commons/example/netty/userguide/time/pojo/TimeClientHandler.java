package com.spike.commons.example.netty.userguide.time.pojo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.apache.log4j.Logger;

/**
 * time service client handler
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

  private static final Logger LOG = Logger.getLogger(TimeClientHandler.class);

  /**
   * occurs when new data is received from a client
   */
  @Override
  public void channelRead(ChannelHandlerContext context, Object message) {
    // ByteBuf bb = (ByteBuf) message;
    // try {
    // long currentTimeMillis = (bb.readUnsignedInt() - 2208988800L) *
    // 1000L;
    // System.out.println(new Date(currentTimeMillis));
    // } catch (Exception e) {
    // e.printStackTrace();
    // } finally {
    // bb.release();
    // }

    // 直接使用pojo
    UnixTime m = (UnixTime) message;

    System.err.println(m);

    context.close();
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
