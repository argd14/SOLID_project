package com.kodigo.solid.commands.doctor;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.kodigo.solid.commands.CommandMetadata;
import com.kodigo.solid.commands.core.CliCommands;
import com.kodigo.solid.services.doctor.IConsultationService;

@Parameters(
    commandNames = {CliCommands.DOCTOR},
    separators = "=",
    commandDescription = "Manage doctor activities")
public class DoctorCommand extends CommandMetadata {

  @Parameter(
      names = {"-createConsultation", "-cc"},
      arity = 0,
      description = "create a new consultation")
  boolean consultation = false;

  private IConsultationService consultationService;

  public DoctorCommand(String commandName, IConsultationService consultationService) {
    super(commandName);
    this.consultationService = consultationService;
  }

  public DoctorCommand(String commandName) {
    super(commandName);
  }

  public boolean isConsultation() {
    return consultation;
  }

  @Override
  public void execute() {
    if (this.isConsultation()) {
      this.consultationService.createConsultation();
    }
  }
}
