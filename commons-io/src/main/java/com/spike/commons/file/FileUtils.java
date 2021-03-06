package com.spike.commons.file;

import static com.spike.commons.lang.StringUtils.FILE_SEP;
import static com.spike.commons.lang.StringUtils.REPEAT;
import static com.spike.commons.lang.StringUtils.TAB;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.spike.commons.lang.StringUtils;

/**
 * 文件操作工具类
 * @author zhoujiagen
 */
public final class FileUtils {

  /**
   * 查看压缩文件中内容, 支持zip, jar
   * @param compressedFilePath
   * @return
   * @throws Exception
   */
  public static String lsCompressedFile(String compressedFilePath) throws Exception {
    StringBuilder sb = new StringBuilder();

    try (ZipFile zipFile = new ZipFile(compressedFilePath);) {
      Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
      while (zipEntries.hasMoreElements()) {
        ZipEntry zipEntry = (ZipEntry) zipEntries.nextElement();
        // System.out.println(zipEntry);
        sb.append(zipEntry.getName()).append(StringUtils.NEWLINE);
      }
      return sb.toString();
    }
  }

  /**
   * 模拟操作系统tree命令
   * @param dirPath
   * @throws IOException
   */
  public static final void tree(String dirPath) throws IOException {
    if (!Files.isDirectory(Paths.get(dirPath), LinkOption.NOFOLLOW_LINKS)) {
      return;
    }

    FileVisitor<? super Path> visitor = new InnerFileVisitor(dirPath);
    Files.walkFileTree(Paths.get(dirPath), visitor);
  }

  /**
   * 获取所有的子目录
   * @param dirPath The directory path
   * @return ordered (short) sub-directory name tree set
   * @throws IOException
   */
  public static final TreeSet<String> subPaths(final String dirPath) throws IOException {
    if (!Files.isDirectory(Paths.get(dirPath), LinkOption.NOFOLLOW_LINKS)) {
      return null;
    }
    final TreeSet<String> result = new TreeSet<String>();

    Files.walkFileTree(Paths.get(dirPath), new FileVisitor<Path>() {

      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
          throws IOException {
        if (!Paths.get(dirPath).equals(dir)) {
          String thisPath = dir.toAbsolutePath().toString();
          thisPath = thisPath.substring(dirPath.length() - 1, thisPath.length());

          result.add(thisPath);
        }

        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        if (exc != null) exc.printStackTrace();
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (exc != null) exc.printStackTrace();
        return FileVisitResult.CONTINUE;
      }
    });

    return result;
  }

  private static class InnerFileVisitor extends SimpleFileVisitor<Path> {

    private int level;

    public InnerFileVisitor(String pathPrefix) {
      this.level = pathPrefix.split(FILE_SEP).length;
      System.out.println(level);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
      System.out.println(REPEAT(TAB, file.toAbsolutePath().toString().split(FILE_SEP).length
          - level)
          + file.getFileName().toString());

      // do something here

      return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
        throws IOException {

      System.out
          .println(REPEAT(TAB, dir.toAbsolutePath().toString().split(FILE_SEP).length - level)
              + dir.getFileName());

      return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
      if (exc != null) exc.printStackTrace();
      return FileVisitResult.CONTINUE;
    }
  }

}
