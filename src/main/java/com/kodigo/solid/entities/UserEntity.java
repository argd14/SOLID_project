package com.kodigo.solid.entities;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

public class UserEntity implements Serializable {

  @Getter private String name;
  @Getter private LocalDate birthday;
  @Getter private String phoneNumber;
  @Getter private String email;
  @Getter public String password;
  public int id;
  public String Username;
  public int Role;

  public UserEntity(
          int id, String name, LocalDate birthday, String phoneNumber, String email,  String username, String password, int role) {
    this.name = name;
    this.birthday = birthday;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.id = id;
    this.Username = username;
    this.Role = role;
  }

  public UserEntity(){

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
