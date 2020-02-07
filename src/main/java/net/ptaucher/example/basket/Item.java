package net.ptaucher.example.basket;

public class Item {
  final String name;
  final int qty;
  final double unitPrice;

  public Item(String name, int qty, double unitPrice) {
    this.name = name;
    this.qty = qty;
    this.unitPrice = unitPrice;
  }

  public String getName() {
    return name;
  }

  public int getQty() {
    return qty;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public double getTotalPrice() {
    return unitPrice * qty;
  }
}
