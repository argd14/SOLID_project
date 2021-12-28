package com.kodigo.solid.entities;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

public class UserEntity implements Serializable {

  @Getter private String name;
  @Getter private LocalDate birthday;
  @Getter private String phoneNumber;
  @Getter private String email;
  @Getter private String password;

  public UserEntity(
      String name, LocalDate birthday, String phoneNumber, String email, String password) {
    this.name = name;
    this.birthday = birthday;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserEntity{"
        + "name='"
        + name
        + '\''
        + ", birthday="
        + birthday
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + ", email='"
        + email
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
}
