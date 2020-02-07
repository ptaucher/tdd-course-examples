package net.ptaucher.example.biggerandsmaller;

public class BiggerAndSmaller {
  int bigger;
  int smaller;

  public BiggerAndSmaller() {
    reset();
  }

  public void find(int... numbers) {
    for (int i : numbers) {
      if (i < smaller) {
        smaller = i;
      }
      if (i > bigger) {
        bigger = i;
      }
    }
  }

  public int getBigger() {
    return bigger;
  }

  public int getSmaller() {
    return smaller;
  }

  public void reset() {
    bigger = Integer.MIN_VALUE;
    smaller = Integer.MAX_VALUE;
  }
}
