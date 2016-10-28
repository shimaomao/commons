package com.spike.commons.example.nio2.walk.loganalysis;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Test;

public class LogAnalysisTaskTest {
  @Test
  public void testCall() throws Exception {
    Path path =
        FileSystems.getDefault().getPath("D:/sts-workspace/javaiospike/src/test/resources",
          "sample_exception.txt");
    LogAnalysisTask task = new LogAnalysisTask(path);
    task.call();
  }
}
