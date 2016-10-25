package com.spike.commons.example.netty.util;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * <pre>
 * Constants used for Netty Applications
 * Netty应用中常量
 * 
 * </pre>
 * @author zhoujiagen
 */
public class NettyAppConstants {

  /** 默认的主机 */
  public static final String DEFAULT_HOST = "127.0.0.1";

  /** 默认的端口 */
  public static final int DEFAULT_PORT = 8888;

  /** 默认的Socket地址 */
  public static final SocketAddress DEFAULT_ADDRESS = new InetSocketAddress(DEFAULT_HOST,
      DEFAULT_PORT);

}
