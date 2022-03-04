package com.arminzheng.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * GuavaTest
 *
 * @author zy
 * @version 2022/3/4
 */
public class GuavaTest {

  @Test
  public void testI() {
    ArrayList<String> testList = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", null);
    Lists.partition(testList, 5).forEach(item -> {
      System.out.println(item);
      System.out.println("=========");
    });
    Joiner joiner = Joiner.on(",")
        // .skipNulls();
        .useForNull("null");
    System.out.println(joiner.join(testList));
  }

  @Test
  public void testII() {
    ArrayList<String> listA = Lists.newArrayList("1", "2");
    ArrayList<String> listB = Lists.newArrayList("3", "4");

    System.out.println(Lists.cartesianProduct(listA, listB));
  }
}
