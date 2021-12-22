package com.kodigo.solid.entities;

import java.util.Date;

public class ReceptionistEntity extends UserEntity {
  public ReceptionistEntity(
      String name, Date birthday, String phoneNumber, String email, String password) {
    super(name, birthday, phoneNumber, email, password);
  }
}
