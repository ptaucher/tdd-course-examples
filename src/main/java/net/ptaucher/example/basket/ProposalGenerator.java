package net.ptaucher.example.basket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProposalGenerator {
  final Calendar calendar;

  public ProposalGenerator(Calendar calendar) {
    this.calendar = calendar;
  }

  public double calculateDiscount(Basket basket) {
    if (january()) {
      return basket.getAmount() * 0.05;
    } else if (christmas()) {
      return basket.getAmount() * 0.15;
    }

    return 0;
  }

  private boolean christmas() {
    return new SimpleDateFormat("MM.dd").format(calendar.now()).equals("12.25");
  }

  private boolean january() {
    return new SimpleDateFormat("MM").format(calendar.now()).equals("01");
  }
}
