package com.kodigo.solid;

import com.kodigo.solid.utils.Menu;

import java.util.List;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    List lista = Stream.of("opcionA", "opcionB", "opcionC").toList();
    var menu = new Menu("AdminMenu", lista);

    int choice = menu.showMenu();
  }
}
