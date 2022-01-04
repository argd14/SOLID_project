package com.kodigo.solid.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data

@NoArgsConstructor
public class PatientEntity extends UserEntity  {
  private PatientEntity prescription;

  public PatientEntity(int id, String username, String name, LocalDate date, String phone, String email, String password, int rol) {
  }

}