package com.kodigo.solid.commands.admin;

import com.kodigo.solid.data.fakedb.PatientDataManagement;
import com.kodigo.solid.data.repositories.PatientRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.PatientEntity;
import picocli.CommandLine.Command;

import java.util.Date;
import java.util.concurrent.Callable;

@Command(name = "cp")
public class CreatePatientCommand implements Callable<Integer> {
  private Repository<PatientEntity> patientEntityRepository;

  public CreatePatientCommand() {
    this.patientEntityRepository = new PatientRepository(new PatientDataManagement());
  }

  @Override
  public Integer call() throws Exception {

    PatientEntity patient =
        new PatientEntity(
            1, "admin", new Date(), "9999-7777", "admin@gmail.com", "secretpass", "Masculino");
    System.out.println("repo");
    this.patientEntityRepository.save(patient);

    return 1;
  }
}
