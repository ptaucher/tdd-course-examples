package net.ptaucher.example.basket;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class ProposalGeneratorTest {
  Calendar calendar;

  @Before
  public void setUp() {
    calendar = Mockito.mock(Calendar.class);
  }

  @Test
  public void discountWhenChristmas() throws ParseException {
    Basket basket = new BasketBuilder()
        .add("NOTEBOOK", 1, 900)
        .add("WINDOWS PHONE", 1, 100)
        .build();

    Mockito.when(calendar.now()).thenReturn(new SimpleDateFormat("yyyy-MM-dd").parse("1999-12-25"));

    ProposalGenerator generator = new ProposalGenerator(calendar);
    double finalAmount = generator.calculateDiscount(basket);

    assertEquals(1000 * 0.15, finalAmount, 0.0001);
  }

  @Test
  public void discountWhenJanuary() throws ParseException {
    Basket basket = new BasketBuilder()
        .add("NOTEBOOK", 1, 900)
        .add("WINDOWS PHONE", 1, 100)
        .build();

    Mockito.when(calendar.now()).thenReturn(new SimpleDateFormat("yyyy-MM-dd").parse("1999-01-25"));

    ProposalGenerator generator = new ProposalGenerator(calendar);
    double finalAmount = generator.calculateDiscount(basket);

    assertEquals(1000 * 0.05, finalAmount, 0.0001);
  }
}
