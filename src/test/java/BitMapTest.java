public class BitMapTest {
  public static void main(String[] args) {
    String s = "abcbzxyw";
    int[] last = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    int n = s.length();

    int res = 0;
    int start = 0; // 窗口开始位置
    for (int i = 0; i < n; i++) {
      int index = s.charAt(i);
      System.out.println("current Index = " + index);

      start = Math.max(start, last[index]);
      System.out.println("start = " + start);

      res = Math.max(res, i - start + 1);
      System.out.println("ret = " + res);

      last[index] = i + 1;
    }
  }
}
