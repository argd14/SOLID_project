package com.kodigo.solid.views.utils;

import lombok.Getter;

import java.util.List;
import java.util.Scanner;

public class Menu {
  @Getter private final String title;
  @Getter private final List<String> options;

  public Menu(String title, List<String> options) {
    this.title = title;
    this.options = options;
  }

  public int showMenu() {
    Scanner input = new Scanner(System.in);
    int choice = 0;
    System.out.println('\n' + this.title);

    do {
      for (int i = 0; i < this.options.size(); i++) {
        System.out.println((i + 1) + " - " + this.options.get(i));
      }

      if (input.hasNextInt()) {
        choice = input.nextInt();
      }

      if (choice > 0 && (choice - 1) < this.options.size()) {
        return choice - 1;
      }

    } while (true);
  }
}
