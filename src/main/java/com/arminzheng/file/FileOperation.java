package com.arminzheng.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

/**
 * FileOperation
 *
 * @author zy
 * @version 2022/2/18
 */
public class FileOperation {

  public static void main(String[] args) throws UnsupportedEncodingException {
    File file = Paths.get("test.txt").toFile();
    read(file);
    // write(file);
    byte[] data = new byte[0];
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      output.write("Hello ".getBytes(StandardCharsets.UTF_8));
      output.write("world!".getBytes(StandardCharsets.UTF_8));
      data = output.toByteArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(new String(data, StandardCharsets.UTF_8));
  }

  /**
   * 操作系统往往会一次性读取若干字节到缓冲区, 读取下一个字节时，可以直接返回缓冲区的下一个字节, 而不是真的每次只读一个字节
   *
   * @param file 文件
   */
  private static void read(File file) {
    try (FileInputStream input = new FileInputStream(file); // 多个 AutoCloseable 资源用分号隔开
        FileInputStream input2 = new FileInputStream(file)) {
      int n;
      /* read1
      while ((n = input.read()) != -1) {
        System.out.print((char) n); // 读取的字节
      }*/
      /* read 2
      byte[] bytes = new byte[500];
      while ((n = input.read(bytes)) != -1) {
        System.out.println("read " + n + " bytes."); // 500 /n 290
      }*/
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  /**
   * 注意多了flush方法。
   *
   * <p>操作系统往往会先放到内存的一个缓冲区里（本质是一个byte[]数组）, 等到缓冲区写满了，再一次性写入文件或者网络。
   *
   * <p>调用close()方法关闭OutputStream之前，会自动调用flush()方法。
   *
   * <p>主要方法：public abstract void write(int b) throws IOException;
   *
   * @param file 文件
   */
  private static void write(File file) {
    try (FileOutputStream output = new FileOutputStream(file)) {
      output.write(72); // H
      output.write(101); // e
      output.write(108); // l
      output.write(108); // l
      output.write(111); // o
      output.flush();
      output.write(" World".getBytes(StandardCharsets.UTF_8)); // echo " World" > file # 注意不是 >>
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
