package com.kodigo.solid.utils.usefullObjects;

import lombok.Getter;

public class Medicine {
  @Getter private String name;
  @Getter private String brand;
  @Getter private double price;

  public Medicine(String name, String brand, double price) {
    this.name = name;
    this.brand = brand;
    this.price = price;
  }

  @Override
  public String toString() {
    return "Medicine{"
        + "name='"
        + name
        + '\''
        + ", brand='"
        + brand
        + '\''
        + ", price="
        + price
        + '}';
  }
}
