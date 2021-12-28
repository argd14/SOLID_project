package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.DoctorDataManagement;
import com.kodigo.solid.data.repositories.DoctorRepository;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.time.LocalDate;

public class DoctorEntity extends UserEntity implements Entity, Serializable {
  @Getter private int id;
  //@Getter private MedicalSpecialties specialty;

  @SneakyThrows
  public DoctorEntity(
      String name, LocalDate birthday, String phoneNumber, String email, String password) {
    super(name, birthday, phoneNumber, email, password);

    this.id = new DoctorRepository(new DoctorDataManagement()).count();
  }

  @Override
  public String toString() {
    return "DoctorEntity{" + "specialty="  + '}';
  }
}
