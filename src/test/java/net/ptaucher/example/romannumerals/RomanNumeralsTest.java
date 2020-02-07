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

  // VII - 7
  // XVI - 16
  // IV - 4
  // XIV - 14
}
