package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.SourceData;

import java.io.IOException;
import java.util.Date;

public class ReceptionistEntity extends UserEntity {
  public ReceptionistEntity(
      String name,
      Date birthday,
      String phoneNumber,
      String email,
      String password,
      SourceData databaseOfthisEntity,
      String filePath)
      throws IOException, ClassNotFoundException {
    super(name, birthday, phoneNumber, email, password, databaseOfthisEntity, filePath);
  }
}
