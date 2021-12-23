package com.kodigo.solid;

import com.kodigo.solid.commands.core.CommandsPool;

public class Main {

  public static void main(String[] args) {
    CommandsPool.getInstance().run(args);
  }
}
