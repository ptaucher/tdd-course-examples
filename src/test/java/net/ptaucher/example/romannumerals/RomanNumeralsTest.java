package net.ptaucher.example.romannumerals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest {
  final RomanNumeral roman = new RomanNumeral();

  // I - 1
  @Test
  public void testI() {
    int number = roman.convert("I");
    assertEquals(1, number);
  }

  // II - 2
  @Test
  public void testII() {
    int number = roman.convert("II");
    assertEquals(2, number);
  }

  // III - 3
  @Test
  public void testIII() {
    int number = roman.convert("III");
    assertEquals(3, number);
  }

  // V - 5
  @Test
  public void testV() {
    int number = roman.convert("V");
    assertEquals(5, number);
  }

  // X - 10
  @Test
  public void testX() {
    int number = roman.convert("X");
    assertEquals(10, number);
  }

  // XIV - 14
  @Test
  public void testXIV() {
    int number = roman.convert("XIV");
    assertEquals(14, number);
  }

  // XIV - 15
  @Test
  public void testXV() {
    int number = roman.convert("XV");
    assertEquals(15, number);
  }

  // XVI - 16
  @Test
  public void testXVI() {
    int number = roman.convert("XVI");
    assertEquals(16, number);
  }

  // LLXXVVII - 132
  @Test
  public void testLLXXVVII() {
    int number = roman.convert("LLXXVVII");
    assertEquals(132, number);
  }

  // XLIV - 44
  @Test
  public void testXLIV() {
    int number = roman.convert("XLIV");
    assertEquals(44, number);
  }
}
