package com.spike.commons.example.netty.userguide.time.stream.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * <pre>
 * handle buffer 32-bit integer segmentation
 * 处理32位字节分片
 * 
 * {@link ByteToMessageDecoder}是{@link ChannelInboundHandler}的实现，可以方便的处理分片问题
 * 
 * </pre>
 * @see ByteToMessageDecoder
 * @see ReplayingDecoder
 */
public class TimeDecoder extends ByteToMessageDecoder {

  /**
   * 在内部buffer中没有足够的数据时，不加入输出中 {@link #internalBuffer()} in 内部维护的累加buffer
   */
  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    if (in.readableBytes() < 4) {
      return;
    }

    // 加入输出中
    out.add(in.readBytes(4));
  }

}
