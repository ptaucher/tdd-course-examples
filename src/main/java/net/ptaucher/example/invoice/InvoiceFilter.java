package net.ptaucher.example.invoice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InvoiceFilter {
  final InvoiceRespository respository;

  public InvoiceFilter(InvoiceRespository respository) {
    this.respository = respository;
  }

  public List<Invoice> filter() {
    List<Invoice> filtered = new ArrayList<>();

    for (Invoice invoice : respository.all()) {
      if (invoice.getValue() > 2000) {
        filtered.add(invoice);
      } else if (invoice.getValue() < 2000 && invoice.getName().equals("MICROSOFT")) {
        filtered.add(invoice);
      } else if (invoice.getDate().get(Calendar.YEAR) < 1999) {
        filtered.add(invoice);
      }
    }

    return filtered;
  }
}
