package com.spike.commons.example.nio2.async.file;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

import com.spike.commons.lang.StringUtils;

public class AsyncFileWriteWithFuture {

  public static void main(String[] args) {
    String content = "what is rational is real and what is real is rational.";
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 5; i++) {
      sb.append(content).append(StringUtils.NEWLINE);
    }

    ByteBuffer bb = ByteBuffer.wrap(sb.toString().getBytes());
    Path path = Paths.get(StringUtils.USER_HOME, "a.txt");

    try (AsynchronousFileChannel channel =
        AsynchronousFileChannel.open(path, StandardOpenOption.WRITE)) {
      Future<Integer> future = channel.write(bb, 100);

      while (!future.isDone()) {
        System.out.print(".");
      }
      System.out.println();

      System.out.println("done? " + future.isDone());
      System.out.println("write " + future.get() + " bytes");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
