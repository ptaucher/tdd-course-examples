package net.ptaucher.example.basket;

import java.util.List;

public class Basket {
  double amount;
  List<Item> items;

  public Basket(List<Item> items) {
    this.items = items;
    sumItems();
  }

  private void sumItems() {
    amount = items.stream().mapToDouble(i -> i.getTotalPrice()).sum();
  }

  public void subtract(double amount) {
    this.amount -= amount;
  }

  public void add(double amount) {
    this.amount += amount;
  }

  public double getAmount() {
    return amount;
  }

  public List<Item> getItems() {
    return items;
  }

  public int qtyOfItems() {
    return items.size();
  }

  public boolean has(String itemName) {
    return items.stream().map(Item::getName).anyMatch(i -> i.equals(itemName));
  }
}
