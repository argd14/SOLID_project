package com.kodigo.solid.commands.core;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.MissingCommandException;
import com.beust.jcommander.ParameterException;
import com.kodigo.solid.commands.CommandMetadata;
import com.kodigo.solid.commands.HelloCommand;
import com.kodigo.solid.commands.LoginCommand;
import com.kodigo.solid.commands.doctor.DoctorCommand;
import com.kodigo.solid.data.repositories.DoctorRepository;
import com.kodigo.solid.services.auth.AuthServiceImplementation;

import java.util.Arrays;
import java.util.List;

public final class CommandsPool {
  private static CommandsPool instance;

  private CommandsPool() {}

  public static CommandsPool getInstance() {
    if (instance == null) {
      instance = new CommandsPool();
    }
    return instance;
  }

  private void commandsDeclarationAndBuild(String[] args) {

    LoginCommand logginCommand =
        new LoginCommand(CliCommands.LOGIN, new AuthServiceImplementation(new DoctorRepository()));
    HelloCommand helloCommand = new HelloCommand(CliCommands.HELLO);
    DoctorCommand doctorCommand = new DoctorCommand(CliCommands.DOCTOR);

    List<CommandMetadata> commands = Arrays.asList(logginCommand, helloCommand, doctorCommand);

    JCommander jcCli =
        JCommander.newBuilder()
            .addCommand(helloCommand)
            .addCommand(logginCommand)
            .addCommand(doctorCommand)
            .build();

    try {
      jcCli.parse(args);
    } catch (MissingCommandException e) {
      System.out.println(e.getMessage());
    } catch (ParameterException e) {
      System.out.println(e.getMessage());
    }
    String parsedCommand = jcCli.getParsedCommand();

    this.searchCommandToExecute(commands, parsedCommand);
  }

  private void searchCommandToExecute(List<CommandMetadata> commands, String parsedCommand) {

    for (CommandMetadata command : commands) {
      if (command.getCommandName().equals(parsedCommand)) {
        System.out.println("executing command > " + command.getCommandName());
        command.execute();
      }
    }
  }

  public void run(String[] args) {
    this.commandsDeclarationAndBuild(args);
  }
}
