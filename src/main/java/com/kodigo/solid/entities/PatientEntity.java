package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.PatientDataManagement;
import com.kodigo.solid.data.repositories.PatientRepository;
import lombok.Getter;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class PatientEntity extends UserEntity implements Entity, Serializable {
  @Getter private int id;

  public PatientEntity(
      String name, LocalDate birthday, String phoneNumber, String email, String password)
      throws IOException, ClassNotFoundException {
    super(name, birthday, phoneNumber, email, password);
    this.id = new PatientRepository(new PatientDataManagement()).count() + 1;
  }

  @Override
  public String toString() {
    return super.toString() + "PatientEntity{" + "id=" + id + '\'' + '}';
  }
}
