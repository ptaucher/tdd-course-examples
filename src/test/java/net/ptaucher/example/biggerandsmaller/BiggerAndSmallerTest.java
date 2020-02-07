package net.ptaucher.example.biggerandsmaller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BiggerAndSmallerTest {
  final BiggerAndSmaller algorithm = new BiggerAndSmaller();

  @Before
  public void setUp() {
    algorithm.reset();
  }

  @Test
  public void testFindNumbersIncreasingOrder() {
    algorithm.find(2, 3, 4, 5, 11, 55);
    assertNumbers(55, 2);
  }

  @Test
  public void testFindNumbersDecreasingOrder() {
    algorithm.find(55, 11, 5, 4, 3, 2);
    assertNumbers(55, 2);
  }

  @Test
  public void testFindSingleNumber() {
    algorithm.find(55);
    assertNumbers(55, 55);
  }

  @Test
  public void testFindWithoutNumber() {
    algorithm.find();
    assertNumbers(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  void assertNumbers(int bigger, int smaller) {
    assertEquals(bigger, algorithm.getBigger());
    assertEquals(smaller, algorithm.getSmaller());
  }
}
