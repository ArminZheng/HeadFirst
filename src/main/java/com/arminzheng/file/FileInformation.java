package com.arminzheng.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件信息和存在相关类File
 *
 * <p>信息的含义，就是路径
 *
 * @author zy
 * @version 2022/2/18
 */
public class FileInformation {

  /**
   * 什么是文件
   *
   * <p>广义文件：文件isFile、文件夹isDirectory、路径getCanonicalPath、权限canRead/canWrite/canExecute、信息length
   *
   * <p>文件操作：创建（mkdir[s](s指-p父目录)/createNewFile）、读取、写入、删除delete（如果是目录，必须为空才能删除）、临时文件createTempFile(只创建不删除)、退出时删除deleteOnExit
   *
   * <p>文件类型：二进制文件、文本文件
   *
   * <p>File的对象关联不会磁盘操作。只有当调用File对象的某些方法的时候，才真正进行磁盘操作。
   *
   * <p>对象关联，其实就是路径和对象进行绑定，解决分隔符的问题，可使用Paths.get()来构建 Path对象再 toFile进行io操作，可迭代输出get里面的内容
   *
   * <p>存在的问题：1. 文件的读取和写入还未解决
   *
   * <p>从Java 7开始，提供了Files和Paths这两个工具类，能极大地方便我们读写文件。
   *
   * @see FilesOperation
   * @param args 命令行
   */
  public static void main(String[] args) throws IOException {
    System.out.println(File.separator);

    File file = new File(".\\test.txt");
    System.out.println("file.getPath() = " + file.getPath());
    System.out.println("file = " + file.getAbsolutePath());
    System.out.println("file = " + file.getCanonicalPath());
    System.out.println("file = " + file.canRead());

    Path p1 = Paths.get(".", ".\\test.txt");
    System.out.println(p1);
    Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
    System.out.println(p2);
    Path p3 = p2.normalize(); // 转换为规范路径
    System.out.println(p3);
    File f = p3.toFile(); // 转换为File对象
    System.out.println(f);
    for (Path p : p1) { // 可以直接遍历Path
      System.out.println("  " + p); // "." "." "test.txt"
    }
  }
}
