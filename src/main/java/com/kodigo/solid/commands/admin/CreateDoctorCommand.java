package com.kodigo.solid.commands.admin;

import com.kodigo.solid.data.fakedb.DoctorDataManagement;
import com.kodigo.solid.data.repositories.DoctorRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.DoctorEntity;
import picocli.CommandLine;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "createDoctor")
public class CreateDoctorCommand implements Callable<Integer> {
  private Repository<DoctorEntity> doctorEntityRepository;

  public CreateDoctorCommand() {
    this.doctorEntityRepository = new DoctorRepository(new DoctorDataManagement());
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

    DoctorEntity doctor = new DoctorEntity(name, LocalDate.parse(birthday), phone, email, password);

    this.doctorEntityRepository.save(doctor);

    return 1;
  }
}
