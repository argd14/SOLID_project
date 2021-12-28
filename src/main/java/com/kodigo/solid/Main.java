package com.kodigo.solid;

import com.kodigo.solid.commands.RootCommand;
import com.kodigo.solid.commands.admin.AdminCommand;
import com.kodigo.solid.commands.admin.CreatePatientCommand;
import com.kodigo.solid.commands.admin.ListPatientsCommand;
import picocli.CommandLine;

public class Main {

  public static void main(String[] args) {
    int exitCode =
        new CommandLine(new RootCommand())
            .addSubcommand(
                "admin",
                new CommandLine(new AdminCommand())
                    .addSubcommand(new CreatePatientCommand())
                    .addSubcommand(new ListPatientsCommand()))
            .execute(args);
  }
}
