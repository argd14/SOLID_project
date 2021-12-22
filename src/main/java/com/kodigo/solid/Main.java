package com.kodigo.solid;

import com.kodigo.solid.commands.core.CommandsPool;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    CommandsPool.getInstance().run(args);
  }
}
