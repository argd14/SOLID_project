package com.kodigo.solid.commands;

import lombok.Getter;

public abstract class CommandMetadata {
  @Getter public String commandName;

  public CommandMetadata(String commandName) {
    this.commandName = commandName;
  }

  public abstract void execute();
}
