package com.kodigo.solid.entities;

import lombok.Getter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class UserEntity {
  private static final AtomicInteger count = new AtomicInteger(0);
  @Getter private int id;
  @Getter private String name;
  @Getter private Date birthday;
  @Getter private String phoneNumber;
  @Getter private String email;
  @Getter private String password;

  public UserEntity(String name, Date birthday, String phoneNumber, String email, String password) {
    this.name = name;
    this.birthday = birthday;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.id = count.incrementAndGet();
  }

  @Override
  public String toString() {
    return "UserEntity{"
        + "id="
        + id
        + ", name='"
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
