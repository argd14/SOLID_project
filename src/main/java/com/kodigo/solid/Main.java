package com.kodigo.solid;

<<<<<<< HEAD
import com.kodigo.solid.utils.Menu;

import java.util.List;
import java.util.stream.Stream;
=======

import com.kodigo.solid.services.auth.AuthServiceImplementation;
>>>>>>> origin/Roxana

public class Main {

  public static void main(String[] args) {
<<<<<<< HEAD
    List lista = Stream.of("opcionA", "opcionB", "opcionC").toList();
    var menu = new Menu("AdminMenu", lista);
    int choice = menu.showMenu();
=======
    AuthServiceImplementation login = new AuthServiceImplementation();
    login.userLogin();
>>>>>>> origin/Roxana
  }
}
