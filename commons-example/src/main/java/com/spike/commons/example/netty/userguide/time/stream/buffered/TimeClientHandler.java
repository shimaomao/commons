package com.spike.commons.example.netty.userguide.time.stream.buffered;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <pre>
 *  time service client handler
 * 在基于流的协议中的应用
 *
 *
 * </pre>
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
  private static final Logger LOG = Logger.getLogger(TimeClientHandler.class);

  // 内部累加的缓冲区
  private ByteBuf buf;

  /**
   * ChannelHandler生命周期listener1: 添加时
   */
  @Override
  public void handlerAdded(ChannelHandlerContext ctx) {
    // 分配
    buf = ctx.alloc().buffer(4);
  }

  /**
   * ChannelHandler生命周期listener2: 移除时
   */
  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) {
    // 释放
    buf.release();
    buf = null;
  }

  /**
   * <pre>
   * occurs when new data is received from a client
   * 接收到服务端消息时触发，消息的类型是{@link ByteBuf}
   * 
   * </pre>
   */
  @Override
  public void channelRead(ChannelHandlerContext context, Object message) {
    ByteBuf bb = (ByteBuf) message;
    // 首先写入累加缓冲区
    buf.writeBytes(bb);
    bb.release();

    if (buf.readableBytes() >= 4) {// 32 bit integer
      long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
      System.err.println(new Date(currentTimeMillis));

      context.close();
    }
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
