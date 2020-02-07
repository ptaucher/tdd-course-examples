package net.ptaucher.example.invoice;

import java.util.Calendar;
import java.util.Objects;

public class Invoice {
  final Calendar date;
  final String name;
  final int value;

  public Invoice(Calendar date, String name, int value) {
    this.date = date;
    this.name = name;
    this.value = value;
  }

  public Calendar getDate() {
    return date;
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Invoice)) return false;
    Invoice invoice = (Invoice) o;
    return getValue() == invoice.getValue() &&
        Objects.equals(getDate(), invoice.getDate()) &&
        Objects.equals(getName(), invoice.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDate(), getName(), getValue());
  }
}
