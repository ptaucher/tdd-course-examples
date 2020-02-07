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
    Basket basket = new BasketBuilder()
        .add("MACBOOK", 1, 100)
        .add("IPHONE", 1, 50)
        .build();

    applier.apply(basket);

    double baseAmount = basket.getAmount();

    applier.apply(basket);

    assertDiscount(basket, baseAmount,0.15);
  }

  @Test
  public void testDiscountForNotebookAndWindowsPhone() {
    Basket basket = new BasketBuilder()
        .add("NOTEBOOK", 1, 100)
        .add("WINDOWS PHONE", 1, 50)
        .build();

    applier.apply(basket);

    double baseAmount = basket.getAmount();

    applier.apply(basket);

    assertDiscount(basket, baseAmount,0.12);
  }

  @Test
  public void testDiscountForXbox() {
    Basket basket = new BasketBuilder()
        .add("XBOX", 1, 100)
        .build();

    applier.apply(basket);

    double baseAmount = basket.getAmount();

    applier.apply(basket);

    assertDiscount(basket, baseAmount,0.7);
  }

  @Test
  public void testDiscountForMoreThanTwoItemsLesserThanThousand() {
    Basket basket = new BasketBuilder()
        .add("REFRIDGERATOR", 1, 100)
        .build();

    applier.apply(basket);

    double baseAmount = basket.getAmount();

    applier.apply(basket);

    assertDiscount(basket, baseAmount,0.02);
  }

  @Test
  public void testDiscountForMoreThan5Products() {
    Basket basket = new BasketBuilder()
        .add("REFRIDGERATOR", 1, 100)
        .add("DISH WASHER", 1, 100)
        .add("DRYER", 1, 1000)
        .add("TOILET 1", 1, 1500)
        .add("TOILET 2", 1, 1200)
        .add("TOILET 3", 1, 500)
        .build();

    double baseAmount = basket.getAmount();

    applier.apply(basket);

    assertDiscount(basket, baseAmount,0.06);
  }
}
