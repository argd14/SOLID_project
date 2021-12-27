package com.kodigo.solid.entities;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DoctorEntity extends UserEntity {

  public DoctorEntity(
          String dui,
          String name,
          String birthday,
          String phoneNumber,
          String email,
          String password

  ) {
    super(dui, name, birthday, phoneNumber, email, password);

  }
}