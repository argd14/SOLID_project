package main.java.com.kodigo.solid;

//import com.kodigo.solid.commands.RootCommand;
//import com.kodigo.solid.commands.admin.*;
//import com.kodigo.solid.commands.doctor.CreateConsultationCommand;
//import com.kodigo.solid.commands.doctor.DoctorCommandRoot;
//import com.kodigo.solid.commands.doctor.ListConsultsCommand;
//import com.kodigo.solid.commands.receptionist.CreateAppoimentCommand;
//import com.kodigo.solid.commands.receptionist.ReceptionistCommand;
//import picocli.CommandLine;

import main.java.com.kodigo.solid.services.auth.AuthServiceImplementation;

public class Main {

  public static void main(String[] args) {
//    int exitCode =
//        new CommandLine(new RootCommand())
//            .addSubcommand(
//                "admin",
//                new CommandLine(new AdminCommand())
//                    .addSubcommand(new CreatePatientCommand())
//                    .addSubcommand(new ListPatientsCommand())
//                    .addSubcommand(new CreateDoctorCommand())
//                    .addSubcommand(new CreateReceptionistCommand()))
//            .addSubcommand(
//                "recep",
//                new CommandLine(new ReceptionistCommand())
//                    .addSubcommand(new CreateAppoimentCommand()))
//            .addSubcommand(
//                "doctor",
//                new CommandLine(new DoctorCommandRoot())
//                    .addSubcommand(new CreateConsultationCommand())
//                    .addSubcommand(new ListConsultsCommand()))
//            .execute(args);
    AuthServiceImplementation login = new AuthServiceImplementation();
    login.userLogin();
  }
}
