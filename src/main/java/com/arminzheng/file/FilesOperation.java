package com.arminzheng.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * FilesOperation
 *
 * <p>从Java 7开始，提供了Files和Paths这两个工具类，能极大地方便我们读写文件。
 *
 * @author zy
 * @version 2022/2/18
 */
public class FilesOperation {
  /**
   * Files工具类还有createFile()、exists()、copy()、delete()、move()等快捷方法操作文件和目录，入参都是Path。
   *
   * <p>Files提供的读写方法，受内存限制，只能读写小文件，例如配置文件等，不可一次读入几个G的大文件。
   *
   * @param args
   */
  public static void main(String[] args) {
    try {
      if (!Files.exists(Paths.get("test.txt"))) {
        Files.createFile(Paths.get("test.txt"));
      }

      byte[] readAllBytes = Files.readAllBytes(Paths.get("test.txt"));
      // 只适合读小文件
      System.out.println("readAllBytes = " + new String(readAllBytes, StandardCharsets.UTF_8));
      final List<String> strings = Files.readAllLines(Paths.get("test.txt"));
      strings.forEach(System.out::print);

      // 只适合写小文件
      byte[] data = readAllBytes; // 要写入的字节数组
      Files.write(Paths.get("/path/to/file.txt"), data);
      // 按行写入文本:
      List<String> lines = strings; // 要写入的字符串数组
      Files.write(Paths.get("/path/to/file.txt"), lines);
      // 按行写入文本并指定编码:
      Files.write(
          Paths.get("/path/to/file.txt"), Collections.singleton("文本内容..."), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
      // rt: as the title says
    }
  }
}
