package com.kodigo.solid;

import com.kodigo.solid.commands.core.CommandsPool;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String[] argsmock = {"prueba", "--author", "Forrest Gump", "--comer", "--bailar", "--cita"};
    CommandsPool.getInstance().run(argsmock);
  }
}
