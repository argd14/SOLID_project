package com.kodigo.solid.commands.admin;

import com.kodigo.solid.data.fakedb.PatientDataManagement;
import com.kodigo.solid.data.repositories.PatientRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.PatientEntity;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "lp")
public class ListPatientsCommand implements Callable<Integer> {
  private Repository<PatientEntity> patientEntityRepository;

  public ListPatientsCommand() {
    this.patientEntityRepository = new PatientRepository(new PatientDataManagement());
  }

  @Override
  public Integer call() throws Exception {
    System.out.println("pacientes registrados");
    this.patientEntityRepository.findAll().stream().forEach(System.out::println);
    return 1;
  }
}
