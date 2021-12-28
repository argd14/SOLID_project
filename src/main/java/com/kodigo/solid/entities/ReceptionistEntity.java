package com.kodigo.solid.entities;

import java.util.Date;

public class ReceptionistEntity extends UserEntity {
  public ReceptionistEntity(
      String dui, String name, String birthday, String phoneNumber, String email, String password) {
    super(dui, name, birthday, phoneNumber, email, password);
  }
}
