package net.ptaucher.example.invoice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class InvoiceFilterTest {

  private InvoiceRespository respository;
  private InvoiceFilter filter;

  @Before
  public void setUp() {
    respository = Mockito.mock(InvoiceRespository.class);
    filter = new InvoiceFilter(respository);
  }

  @Test
  public void filterInvoicesHigherThan2000() {
    Invoice inv1 = new Invoice(Calendar.getInstance(), "Pedro", 5000);
    Invoice inv2 = new Invoice(Calendar.getInstance(), "Pedro", 800);

    Mockito.when(respository.all()).thenReturn(Arrays.asList(inv1, inv2));

    List<Invoice> result = filter.filter();

    assertEquals(1, result.size());
    assertEquals(inv1, result.get(0));
  }

  @Test
  public void filterInvoicesMicrosoft() {
    Invoice inv1 = new Invoice(Calendar.getInstance(), "Pedro", 1000);
    Invoice inv2 = new Invoice(Calendar.getInstance(), "MICROSOFT", 800);

    Mockito.when(respository.all()).thenReturn(Arrays.asList(inv1, inv2));

    List<Invoice> result = filter.filter();

    assertEquals(1, result.size());
    assertEquals(inv2, result.get(0));
  }
}
