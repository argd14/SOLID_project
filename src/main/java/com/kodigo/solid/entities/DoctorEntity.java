package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.DoctorDataManagement;
import com.kodigo.solid.data.repositories.DoctorRepository;
import com.kodigo.solid.utils.constants.MedicalSpecialties;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.util.Date;

public class DoctorEntity extends UserEntity implements Entity, Serializable {
  @Getter private int id;
  @Getter private MedicalSpecialties specialty;

  @SneakyThrows
  public DoctorEntity(
      String name, Date birthday, String phoneNumber, String email, String password) {
    super(name, birthday, phoneNumber, email, password);
    this.specialty = specialty;
    this.id = new DoctorRepository(new DoctorDataManagement()).count();
  }

  @Override
  public String toString() {
    return "DoctorEntity{" + "specialty=" + specialty + '}';
  }
}
