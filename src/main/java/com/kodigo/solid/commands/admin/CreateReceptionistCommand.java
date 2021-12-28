package com.kodigo.solid.commands.admin;

import com.kodigo.solid.data.fakedb.ReceptionistDataManagement;
import com.kodigo.solid.data.repositories.ReceptionistRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.ReceptionistEntity;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "createReceptionist")
public class CreateReceptionistCommand implements Callable<Integer> {
  private Repository<ReceptionistEntity> receptionistEntityRepository;

  public CreateReceptionistCommand() {
    this.receptionistEntityRepository =
        new ReceptionistRepository(new ReceptionistDataManagement());
  }

  @Override
  public Integer call() throws Exception {
    return null;
  }
}
