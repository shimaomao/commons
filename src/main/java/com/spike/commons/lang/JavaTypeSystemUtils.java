package com.spike.commons.lang;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.spike.commons.algorithm.bean.tree.regular.RegularTree;
import com.spike.commons.algorithm.bean.tree.regular.RegularTreeNode;
import com.spike.commons.file.FileUtils;

/**
 * <pre>
 * Java类型系统工具类
 * 
 * 见org.apache.commons.lang3.reflect和org.apache.commons.beanutils包.
 * </pre>
 * @author zhoujiagen
 */
public final class JavaTypeSystemUtils {
  public static class PackageUtils {

    /**
     * Comparable package based on the name property
     * @author zhoujiagen<br/>
     *         Sep 10, 2015 10:06:39 PM
     */
    public static class ComparablePackage implements Comparable<ComparablePackage> {
      private Package wrapped = null;

      public ComparablePackage(Package pkg) {
        this.wrapped = pkg;
      }

      @Override
      public int compareTo(ComparablePackage other) {
        if (other.getWrapped() == wrapped) {
          return 0;
        }
        return wrapped.getName().compareTo(other.getWrapped().getName());
      }

      public Package getWrapped() {
        return wrapped;
      }

      @Override
      public String toString() {
        return "ComparablePackage [wrapped=" + wrapped.toString() + "]";
      }

    }

    public static final String PACKAGE_SEP = ".";

    public static void main(String[] args) {
      System.out.println(getDefinedPackages());
    }

    public static final List<ComparablePackage> getDefinedPackages() {
      List<ComparablePackage> result = new LinkedList<ComparablePackage>();

      // current package
      Package[] pkgs = Package.getPackages();

      for (Package pkg : pkgs) {
        if (StringUtils.isBlank(pkg.getSpecificationTitle())) {
          result.add(new ComparablePackage(pkg));
        }
      }

      Collections.sort(result);

      return result;
    }

    /**
     * FIXME too slow
     * @param dirPath
     */
    public static final void renderPackageAndClasses(final String dirPath) {
      TreeSet<String> subPaths = FileUtils.subPaths(dirPath);

      Iterator<String> iterator = subPaths.iterator();
      while (iterator.hasNext()) {
        String subPath = iterator.next();
        subPath = dirPath + StringUtils.FILE_SEP + subPath;
        System.out.println(subPath);

        File[] files = new File(subPath).listFiles(new ClassFileFilter());
        if (files != null && files.length > 0) {
          for (File file : files) {
            System.out.print(file.getName() + StringUtils.TAB);
          }
          System.out.println();
        }
      }

    }

    /**
     * <pre>
     * 将文件目录组装为树形结构
     * </pre>
     * @param dirpath
     * @return
     */
    public static RegularTree treeOfPackageAndClasses(final String dirpath) {
      Path dirPath = Paths.get(dirpath);
      if (!Files.isDirectory(dirPath)) {
        return null;
      }

      File[] subFiles = dirPath.toFile().listFiles();
      boolean isLeaf = false;
      if (subFiles == null || subFiles.length == 0) {
        isLeaf = true;
      }

      RegularTreeNode root = new RegularTreeNode(dirPath.toAbsolutePath().toAbsolutePath(), isLeaf);

      // ordered directory names, construct a tree naturally
      TreeSet<String> subPaths = FileUtils.subPaths(dirpath);

      Iterator<String> iterator = subPaths.iterator();
      while (iterator.hasNext()) {
        String subPath = iterator.next();

        RegularTreeNode thisNode = null;

        File subPathFile = new File(dirpath + StringUtils.FILE_SEP + subPath);
        File[] files = subPathFile.listFiles(new ClassFileFilter());
        if (files != null && files.length > 0) {
          thisNode = new RegularTreeNode(subPath, false);
          root.addChild(thisNode);

          // only handle these files that be file not directory
          for (File file : files) {
            if (!file.isDirectory()) {
              thisNode.addChild(new RegularTreeNode(file.getName(), true));
            }
          }
        } else {// empty directory
          // thisNode = new RegularTreeNode(subPath, true);
          // root.addChild(thisNode);
        }
      }

      RegularTree result = new RegularTree(root);

      return result;
    }

    /**
     * <pre>
     * 类文件过滤器
     * </pre>
     */
    private static class ClassFileFilter implements FileFilter {

      @Override
      public boolean accept(File pathname) {
        if (pathname.getName().endsWith("class")) {
          return true;
        }
        return false;
      }

    }

    /**
     * <pre>
     * render *.zip, *.jar file contents
     * 输出zip/jar文件的内容
     * 
     * </pre>
     * @param zipFilePath
     * @see ZipFile
     * @see ZipInputStream
     */
    public static final void renderZipFile(String zipFilePath) {
      try (ZipFile zipFile = new ZipFile(zipFilePath);) {
        Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
        while (zipEntries.hasMoreElements()) {
          ZipEntry zipEntry = (ZipEntry) zipEntries.nextElement();
          System.out.println(zipEntry);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  public static class Reflect {
    public static class TypeUtils extends org.apache.commons.lang3.reflect.TypeUtils {
    }

    public static class MethodUtils extends org.apache.commons.lang3.reflect.MethodUtils {
    }

    public static class ConstructorUtils extends org.apache.commons.lang3.reflect.ConstructorUtils {
    }

    public static class FieldUtils extends org.apache.commons.lang3.reflect.FieldUtils {
    }
  }

  public static class Beans {
    public static class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
    }

    public static class MethodUtils extends org.apache.commons.beanutils.MethodUtils {
    }

    public static class PropertyUtils extends org.apache.commons.beanutils.PropertyUtils {
    }

    public static class ConvertUtils extends org.apache.commons.beanutils.ConvertUtils {
    }
  }

}
