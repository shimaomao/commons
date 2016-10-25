package com.spike.commons.example.netty.book;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import org.apache.log4j.Logger;

/**
 * EchoClient's handler
 * @author zhoujiagen
 */
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
  private static final Logger logger = Logger.getLogger(EchoClientHandler.class);

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
    // logger.info("Client received: " +
    // ByteBufUtil.hexDump(msg.readBytes(msg.readableBytes())));
    logger.info("Client reviced: " + CharsetUtil.UTF_8.decode(msg.nioBuffer()));
  }

  @Override
  public void channelActive(ChannelHandlerContext context) {
    // send some message
    logger.info("Client send some message...");

    // COMMENT: should flush the message!!!
    // context.write(Unpooled.copiedBuffer("Netty rocks!",
    // CharsetUtil.UTF_8));
    context.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
    logger.error("An exception caught: ", cause);

    context.close();
  }
}
