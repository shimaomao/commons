package com.spike.commons.stream;

import java.io.IOException;
import java.io.OutputStream;

/**
 * copied from org.apache.log4j.ConsoleAppender
 * @author zhoujiagen
 */
public final class SystemOutStream extends OutputStream {
  public SystemOutStream() {
  }

  public void close() {
  }

  public void flush() {
    System.out.flush();
  }

  public void write(final byte[] b) throws IOException {
    System.out.write(b);
  }

  public void write(final byte[] b, final int off, final int len) throws IOException {
    System.out.write(b, off, len);
  }

  public void write(final int b) throws IOException {
    System.out.write(b);
  }
}