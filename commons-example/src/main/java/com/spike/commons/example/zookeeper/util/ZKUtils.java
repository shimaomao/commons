package com.spike.commons.example.zookeeper.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ZooKeeper工具类
 * @author zhoujiagen
 */
public final class ZKUtils {
  private static final Logger LOG = LoggerFactory.getLogger(ZKUtils.class);

  /** Zookeeper句柄 */
  private static ZooKeeper ZK_HANDLE;

  private static String NEWLINE = System.lineSeparator();

  /** 根路径 */
  public static String ROOT_PATH = "/";

  /** 默认的watcher */
  private static final class DefaultWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
      LOG.info("默认的watcher观察到事件: " + event);
    }
  }

  /**
   * <pre>
   * 展示目录树
   * </pre>
   * @param connectionString ZooKeeper连接串
   * @param root 根目录
   * @param depth 深度
   */
  public static void listTree(String connectionString, String root, int depth) {
    if (StringUtils.isBlank(connectionString) || StringUtils.isBlank(root) || depth == 0) {
      return;
    }

    if (!root.startsWith(ROOT_PATH)) {
      root = ROOT_PATH + root;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(root + NEWLINE);

    try {
      // 1 init handle
      ZK_HANDLE = new ZooKeeper(connectionString, 15000, new DefaultWatcher());

      // 2 do process
      List<String> rootChildren = ZK_HANDLE.getChildren(root, false);
      if (CollectionUtils.isNotEmpty(rootChildren)) {
        for (String rootChild : rootChildren) {
          sb.append(doListTree(preAppendPath(root, rootChild), depth - 1));
        }
      }

      // System.out.println(sb.toString());

      String[] records = sb.toString().split(NEWLINE);

      List<String> recordList = Arrays.asList(records);
      Collections.sort(recordList);
      for (String record : recordList) {
        System.out.println(record);
      }

      // 3 close handle
      ZK_HANDLE.close();

    } catch (Exception e) {
      LOG.error("查看树目录结构失败", e);
    }
  }

  private static String doListTree(String root, int depth) throws KeeperException,
      InterruptedException {
    StringBuilder sb = new StringBuilder();

    if (depth == 0) {

      sb.append(root + NEWLINE);

    } else {

      List<String> rootChildren = ZK_HANDLE.getChildren(root, false);
      if (CollectionUtils.isNotEmpty(rootChildren)) {
        sb.append(root + NEWLINE);
        for (String rootChild : rootChildren) {
          sb.append(doListTree(preAppendPath(root, rootChild), depth - 1));
        }
      } else {
        sb.append(root + NEWLINE);
      }
    }

    return sb.toString();
  }

  private static String preAppendPath(String root, String child) {
    if (StringUtils.isBlank(root) || StringUtils.isBlank(child)) {
      return null;
    }

    if (ROOT_PATH.equals(root)) {
      return root + child;
    } else {
      return root + ROOT_PATH + child;
    }

  }

  public static void main(String[] args) throws KeeperException, InterruptedException {
    listTree(ZKConstants.DEFAULT_QUORUM_CONN_STRING, ROOT_PATH, 10);
    // listTree("127.0.0.1:2188", ROOT_PATH, 10);
    // listTree("127.0.0.1:2188", "/brokers", 10);
    // listTree("127.0.0.1:2188", "/brokers-nonexist", 10);
  }

}
