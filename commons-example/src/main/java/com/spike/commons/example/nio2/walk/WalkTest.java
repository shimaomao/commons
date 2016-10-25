package com.spike.commons.example.nio2.walk;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class WalkTest {
  @Test
  public void testWalkDirRecurisive() throws IOException {
    // 读文件系统中路径
    Path start = FileSystems.getDefault().getPath("C:/logs", "20150414");
    FileVisitor<? super Path> visitor = new MyDirWalker();
    Files.walkFileTree(start, visitor);
  }

}
