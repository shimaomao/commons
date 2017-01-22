package com.spike.commons.stream;

import java.io.IOException;
import java.io.OutputStream;

public final class SystemErrStream extends OutputStream {
  public SystemErrStream() {
  }

  public void close() {
  }

  public void flush() {
    System.err.flush();
  }

  public void write(final byte[] b) throws IOException {
    System.err.write(b);
  }

  public void write(final byte[] b, final int off, final int len) throws IOException {
    System.err.write(b, off, len);
  }

  public void write(final int b) throws IOException {
    System.err.write(b);
  }
}