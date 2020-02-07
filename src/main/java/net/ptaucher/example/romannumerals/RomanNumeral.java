package net.ptaucher.example.romannumerals;

public class RomanNumeral {

  public int convert(String roman) {
    if ("I".equals(roman)) {
      return 1;
    } else if ("II".equals(roman)) {
      return 2;
    } else if ("III".equals(roman)) {
      return 3;
    }else if ("V".equals(roman)) {
      return 5;
    }
    return 0;
  }
}
