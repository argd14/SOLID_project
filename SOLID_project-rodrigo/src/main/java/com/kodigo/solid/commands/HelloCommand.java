package com.kodigo.solid.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.kodigo.solid.commands.core.CliCommands;
import lombok.Getter;

@Parameters(
    commandNames = {CliCommands.HELLO},
    separators = "=",
    commandDescription = "Hello everyone")
public class HelloCommand extends CommandMetadata {
  @Parameter(
      names = {"--greeting", "-gr"},
      description = "return a sweet greeting")
  @Getter
  public String greeting;

  public HelloCommand(String commandName) {
    super(commandName);
  }

  public String getGreeting() {
    return greeting;
  }

  @Override
  public void execute() {
    System.out.println(this.getClass() + " running.");
  }
}
