package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.ReceptionistDataManagement;
import com.kodigo.solid.data.repositories.ReceptionistRepository;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.time.LocalDate;

public class ReceptionistEntity extends UserEntity implements Entity, Serializable {
  @Getter private int id;

  @SneakyThrows
  public ReceptionistEntity(
      String name, LocalDate birthday, String phoneNumber, String email, String password) {
    super(name, birthday, phoneNumber, email, password);
    this.id = new ReceptionistRepository(new ReceptionistDataManagement()).count() + 1;
  }
}
