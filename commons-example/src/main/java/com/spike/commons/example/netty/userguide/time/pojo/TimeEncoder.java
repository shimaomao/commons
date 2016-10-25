package com.spike.commons.example.netty.userguide.time.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * <pre>
 * encode pojo to bytes
 * </pre>
 * @see MessageToByteEncoder
 * @see ChannelOutboundHandlerAdapter
 */
public class TimeEncoder extends MessageToByteEncoder<UnixTime> {

  @Override
  protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) {
    out.writeInt((int) msg.value());
  }
}
