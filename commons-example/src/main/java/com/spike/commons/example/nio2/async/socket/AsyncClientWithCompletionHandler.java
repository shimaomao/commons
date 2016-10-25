package com.spike.commons.example.nio2.async.socket;

import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Random;

import com.spike.commons.example.nio2.SocketConstants;

/**
 * NIO2 features:<br/>
 * AsynchronousSocketChannel with CompletionHandler
 * @see AsynchronousSocketChannel
 * @author zhoujiagen
 */
public class AsyncClientWithCompletionHandler {
  public static void main(String[] args) {
    final ByteBuffer bb = ByteBuffer.allocateDirect(1024);
    final ByteBuffer helloBuffer = ByteBuffer.wrap("Hi!".getBytes());

    try (AsynchronousSocketChannel channel = AsynchronousSocketChannel.open()) {
      if (!channel.isOpen()) {
        System.out.println("cannot open AsynchronousSocketChannel");
        return;
      }

      // set options
      channel.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
      channel.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
      channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

      // connect
      channel.connect(SocketConstants.DEFAULT_ADDRESS, null, new CompletionHandler<Void, Void>() {

        @Override
        public void completed(Void result, Void attachment) {
          try {
            System.out.println("local address: " + channel.getLocalAddress());

            channel.write(helloBuffer).get();

            while (channel.read(bb).get() != -1) {
              bb.flip();
              System.out.println(SocketConstants.DEFAULT_CHARSET.decode(bb));
              if (bb.hasRemaining()) {
                bb.compact();
              } else {
                bb.clear();
              }

              int r = new Random().nextInt(100);
              if (r % 5 == 0) {
                System.out.println("done caused by: " + r);
                break;
              } else {
                channel.write(
                  ByteBuffer.wrap(("random number: ".concat(String.valueOf(r)).getBytes()))).get();
              }
            }

          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            try {
              channel.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }

        @Override
        public void failed(Throwable exc, Void attachment) {
          throw new RuntimeException("cannot establish connection");
        }
      });

      // wait, IMPORTANT
      System.in.read();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
