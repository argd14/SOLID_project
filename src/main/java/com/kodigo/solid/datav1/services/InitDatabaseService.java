package com.kodigo.solid.datav1.services;

import com.kodigo.solid.datav1.fakedb.DoctorDataManagement;
import com.kodigo.solid.datav1.fakedb.PatientDataManagement;
import com.kodigo.solid.datav1.repositories.DoctorRepository;
import com.kodigo.solid.datav1.repositories.PatientRepository;
import com.kodigo.solid.datav1.repositories.Repository;
import com.kodigo.solid.entitiesv1.DoctorEntity;
import com.kodigo.solid.entitiesv1.PatientEntity;

import java.io.IOException;
import java.time.LocalDate;

public class InitDatabaseService {
  private Repository<DoctorEntity> doctorEntityRepository;
  private Repository<PatientEntity> patientEntityRepository;

  public InitDatabaseService() {
    this.patientEntityRepository = new PatientRepository(new PatientDataManagement());
    this.doctorEntityRepository = new DoctorRepository(new DoctorDataManagement());
  }

  public void startUsersDatabases() throws IOException, ClassNotFoundException {
    // Patients
    var patient1 =
        new PatientEntity(
            this.patientEntityRepository.count() + 1,
            "Adam",
            LocalDate.parse("1998-08-10"),
            "7575-6767",
            "adam@gmail.com",
            "secretpassword");
    this.patientEntityRepository.save(patient1);

    var patient2 =
        new PatientEntity(
            this.patientEntityRepository.count() + 1,
            "Adam",
            LocalDate.parse("1998-08-10"),
            "7575-6767",
            "adam@gmail.com",
            "secretpassword");
    this.patientEntityRepository.save(patient2);

    var patient3 =
        new PatientEntity(
            this.patientEntityRepository.count() + 1,
            "Adam",
            LocalDate.parse("1998-08-10"),
            "7575-6767",
            "adam@gmail.com",
            "secretpassword");
    this.patientEntityRepository.save(patient3);

    var patient4 =
        new PatientEntity(
            this.patientEntityRepository.count() + 1,
            "Adam",
            LocalDate.parse("1998-08-10"),
            "7575-6767",
            "adam@gmail.com",
            "secretpassword");
    this.patientEntityRepository.save(patient4);

    var patient5 =
        new PatientEntity(
            this.patientEntityRepository.count() + 1,
            "Adam",
            LocalDate.parse("1998-08-10"),
            "7575-6767",
            "adam@gmail.com",
            "secretpassword");
    this.patientEntityRepository.save(patient5);

    var patient6 =
        new PatientEntity(
            this.patientEntityRepository.count() + 1,
            "Adam",
            LocalDate.parse("1998-08-10"),
            "7575-6767",
            "adam@gmail.com",
            "secretpassword");
    this.patientEntityRepository.save(patient6);

    // Doctors

    var doctor1 =
        new DoctorEntity(
            this.patientEntityRepository.count() + 1,
            "Adam",
            LocalDate.parse("1998-08-10"),
            "7575-6767",
            "adam@gmail.com",
            "secretpassword");
    this.doctorEntityRepository.save(doctor1);
  }
}
