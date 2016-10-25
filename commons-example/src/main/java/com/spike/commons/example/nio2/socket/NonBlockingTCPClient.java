package com.spike.commons.example.nio2.socket;

import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;

import com.spike.commons.example.nio2.SocketConstants;

/**
 * a non-blocking tcp echo client
 * @author zhoujiagen
 */
public class NonBlockingTCPClient {
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.allocateDirect(2 * 1024);

    try (Selector selector = Selector.open(); SocketChannel channel = SocketChannel.open()) {
      if (!selector.isOpen() || !channel.isOpen()) {
        System.out.println("socket connection or selector cannot open");
        return;
      }

      channel.configureBlocking(false);
      channel.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
      channel.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
      channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

      // register
      channel.register(selector, SelectionKey.OP_CONNECT);

      // connect
      channel.connect(new InetSocketAddress(SocketConstants.DEFAULT_HOST,
          SocketConstants.DEFAULT_PORT));
      System.out.println("localhsot: " + channel.getRemoteAddress());

      // a timeout select
      while (selector.select(1000) > 0) {
        Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
        while (iter.hasNext()) {
          SelectionKey key = iter.next();

          iter.remove();

          try (SocketChannel keySocketChannel = (SocketChannel) key.channel()) {
            if (key.isConnectable()) {
              System.out.println("i am connected");

              // close pending connection
              if (keySocketChannel.isConnectionPending()) {
                keySocketChannel.finishConnect();
              }

              // read/write data
              while (keySocketChannel.read(bb) != -1) {
                bb.flip();
                System.out.println(SocketConstants.DEFAULT_CHARSET.decode(bb));

                if (bb.hasRemaining()) {
                  bb.compact();
                } else {
                  bb.clear();
                }

                // send random number
                int r = new Random().nextInt(100);
                if (r % 5 == 0) {
                  System.out.println("stop send data, caused by: " + r);
                  break;
                } else {
                  keySocketChannel.write(ByteBuffer.wrap("Random number: "
                      .concat(String.valueOf(r)).getBytes()));

                  // mock time consuming work: IMPORTANT!!!
                  Thread.sleep(500L);
                }
              }

            }
          } catch (Exception e) {
            e.printStackTrace();
          }

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
