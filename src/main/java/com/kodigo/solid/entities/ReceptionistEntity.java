package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.ReceptionistDataManagement;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Date;

public class ReceptionistEntity extends UserEntity implements Entity {
  @Getter private int id;

  @SneakyThrows
  public ReceptionistEntity(
      String name, Date birthday, String phoneNumber, String email, String password) {
    super(name, birthday, phoneNumber, email, password);
    this.id = new ReceptionistDataManagement().getDataFromTextFileDatabase().size() + 1;
  }
}
