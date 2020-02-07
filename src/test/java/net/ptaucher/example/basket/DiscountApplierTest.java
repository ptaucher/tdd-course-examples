package net.ptaucher.example.basket;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DiscountApplierTest {
  DiscountApplier applier;

  @Before
  public void setUp() {
    applier = new DiscountApplier();
  }

  private void assertDiscount(Basket basket, double amount, double discount) {
    double expected = (amount) * (1 - discount);
    assertEquals(expected, basket.getAmount(), 0.001);
  }

  @Test
  public void testDiscountForMacBookAndIphone() {
    Item item1 = new Item("MACBOOK", 1, 100);
    Item item2 = new Item("IPHONE", 1, 50);

    Basket basket = new Basket(Arrays.asList(item1, item2));

    applier.apply(basket);

    assertDiscount(basket, item1.getTotalPrice() + item2.getTotalPrice(), 0.15);
  }

  @Test
  public void testDiscountForNotebookAndWindowsPhone() {
    Item item1 = new Item("NOTEBOOK", 1, 100);
    Item item2 = new Item("WINDOWS PHONE", 1, 50);

    Basket basket = new Basket(Arrays.asList(item1, item2));

    applier.apply(basket);

    assertDiscount(basket, item1.getTotalPrice() + item2.getTotalPrice(), 0.12);
  }

  @Test
  public void testDiscountForXbox() {
    Item item1 = new Item("XBOX", 1, 100);

    Basket basket = new Basket(Arrays.asList(item1));

    applier.apply(basket);

    assertDiscount(basket, item1.getTotalPrice(), 0.7);
  }

  @Test
  public void testDiscountForMoreThanTwoItemsLesserThanThousand() {
    Item item1 = new Item("REFRIDGERATOR", 1, 100);

    Basket basket = new Basket(Arrays.asList(item1));

    applier.apply(basket);

    assertDiscount(basket, item1.getTotalPrice(), 0.02);
  }

  @Test
  public void testDiscountForMoreThan5Products() {
    Item item1 = new Item("REFRIDGERATOR", 1, 100);
    Item item2 = new Item("DISH WASHER", 1, 500);
    Item item3 = new Item("DRYER", 1, 1500);
    Item item4 = new Item("TOILET 1", 1, 2500);
    Item item5 = new Item("TOILET 2", 1, 1500);
    Item item6 = new Item("TOILET 3", 1, 500);

    Basket basket = new Basket(Arrays.asList(item1, item2, item3, item4, item5, item6));

    applier.apply(basket);

    assertDiscount(basket, item1.getTotalPrice() + item2.getTotalPrice() + item3.getTotalPrice() + item4.getTotalPrice() + item5.getTotalPrice() + item6.getTotalPrice(),
        0.06);
  }
}
