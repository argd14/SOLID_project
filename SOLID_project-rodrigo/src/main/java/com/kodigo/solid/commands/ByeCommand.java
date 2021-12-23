package com.kodigo.solid.commands;

import com.beust.jcommander.Parameter;

public class ByeCommand extends CommandMetadata {

  @Parameter(
      names = {"--goodbye", "-g"},
      description = "return a sweet goodbye")
  private String goodbye;

  public ByeCommand(String commandName) {
    super(commandName);
  }

  public String getGoodbye() {
    return goodbye;
  }

  @Override
  public void execute() {
    System.out.println(this.getClass() + " running.");
  }
}
