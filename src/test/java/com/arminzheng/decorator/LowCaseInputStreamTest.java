package com.arminzheng.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LowCaseInputStreamTest {
    public static void main(String[] args) {
        int c;
        try {
            LowCaseInputStream in = new LowCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("test.txt")
                    ));
            while ((c = in.read()) > 0) {
                System.out.print((char) c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}