package com.kodigo.solid.commands.doctor;

import com.kodigo.solid.data.fakedb.ConsultationDataManagement;
import com.kodigo.solid.data.repositories.ConsultationRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.ConsultationEntity;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "listConsults")
public class ListConsultsCommand implements Callable<Integer> {
  private Repository<ConsultationEntity> consultationEntityRepository;

  public ListConsultsCommand() {
    this.consultationEntityRepository =
        new ConsultationRepository(new ConsultationDataManagement());
  }

  @Override
  public Integer call() throws Exception {
    this.consultationEntityRepository.findAll().stream().forEach(System.out::println);
    return 1;
  }
}
