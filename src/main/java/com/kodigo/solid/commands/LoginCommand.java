package com.kodigo.solid.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.kodigo.solid.commands.core.CliCommands;
import com.kodigo.solid.services.auth.AuthService;

@Parameters(
    commandNames = {CliCommands.LOGIN},
    separators = "=",
    commandDescription = "Login the user to database")
public class LoginCommand extends CommandMetadata {

  @Parameter(names = {"--password"})
  String password;

  private AuthService authService;

  public LoginCommand(String commandName, AuthService authService) {

    super(commandName);
    this.authService = authService;
  }

  @Override
  public void execute() {
    this.authService.login();
    System.out.println("Contraseña introducida: " + this.password);
  }
}
