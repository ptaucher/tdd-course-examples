package net.ptaucher.example.basket;

import java.util.ArrayList;
import java.util.List;

public class BasketBuilder {
  private List<Item> items = new ArrayList<>();

  public BasketBuilder add(String name, int qty, double price) {
    items.add(new Item(name, qty, price));
    return this;
  }

  public Basket build() {
    return new Basket(items);
  }
}
