package net.ptaucher.example.romannumerals;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
  final Map<Character, Integer> table = new HashMap<>();

  public RomanNumeral() {
    table.put('I', 1);
    table.put('V', 5);
    table.put('X', 10);
    table.put('L', 50);
    table.put('C', 100);
    table.put('D', 500);
    table.put('M', 1000);
  }

  public int convert(String roman) {
    int result = 0;
    int current = Integer.MAX_VALUE;

    for (char c: roman.toCharArray()) {
      Integer value = table.get(c);
      if (value != null) {
        if (value > current) {
          result -= (current*2);
        }
        result += value;
        current = value;
      }
    }

    return result;
  }
}
