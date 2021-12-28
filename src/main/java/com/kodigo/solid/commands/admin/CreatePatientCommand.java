package com.kodigo.solid.commands.admin;

import com.kodigo.solid.data.fakedb.PatientDataManagement;
import com.kodigo.solid.data.repositories.PatientRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.PatientEntity;
import picocli.CommandLine.Command;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Callable;

@Command(name = "createPatient")
public class CreatePatientCommand implements Callable<Integer> {
  private Repository<PatientEntity> patientEntityRepository;

  public CreatePatientCommand() {
    this.patientEntityRepository = new PatientRepository(new PatientDataManagement());
  }

  @Override
  public Integer call() throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Nombre >");
    String name = input.nextLine();
    System.out.print("Fecha de nacimiento (yyyy-mm-dd) >");
    String birthday = input.nextLine();
    System.out.print("Telefono >");
    String phone = input.nextLine();
    System.out.print("Email >");
    String email = input.nextLine();
    System.out.print("Password >");
    String password = input.nextLine();

    PatientEntity patient =
        new PatientEntity(name, LocalDate.parse(birthday), phone, email, password);
    this.patientEntityRepository.save(patient);

    return 1;
  }
}
