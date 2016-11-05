package com.spike.commons.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

import com.spike.commons.lang.StringUtils;

/**
 * NIO抽象元素的工厂
 */
public final class NIOAbstractionFactory {

  /**
   * 生成ServerSocketChannel
   * @param port
   * @param blocking 阻塞true, 非阻塞false
   * @return
   * @throws IOException
   */
  public static ServerSocketChannel serverSocketChannel(String host, int port, boolean blocking)
      throws IOException {
    if (StringUtils.isBlank(host)) {
      return null;
    }

    ServerSocketChannel ssc = ServerSocketChannel.open();

    ssc.socket().bind(new InetSocketAddress(host, port));
    ssc.configureBlocking(blocking);

    return ssc;
  }

}
