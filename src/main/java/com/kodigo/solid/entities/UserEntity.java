package com.kodigo.solid.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
public class UserEntity {
  private static final AtomicInteger count = new AtomicInteger(0);
   @Setter@Getter
   private String dui;
   private String name;
   private String birthday;
   private String phoneNumber;
   private String email;
   private String password;


  public UserEntity(String dui,String name, String birthday, String phoneNumber, String email, String password) {
    this.dui = dui;
    this.name = name;
    this.birthday = birthday;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
  }

}
