package com.kodigo.solid.commands.receptionist;

import com.kodigo.solid.data.fakedb.AppoimentDataManagement;
import com.kodigo.solid.data.fakedb.DoctorDataManagement;
import com.kodigo.solid.data.fakedb.PatientDataManagement;
import com.kodigo.solid.data.repositories.AppoimentRepository;
import com.kodigo.solid.data.repositories.DoctorRepository;
import com.kodigo.solid.data.repositories.PatientRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.PatientEntity;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "createAppoiment")
public class CreateAppoimentCommand implements Callable<Integer> {
  @CommandLine.Option(
      names = {"-doctorId", "-dId"},
      required = true)
  Integer doctorId;

  @CommandLine.Option(
      names = {"-patientId", "-pId"},
      required = true)
  Integer patientId;

  private Repository<DoctorEntity> doctorEntityRepository;
  private Repository<PatientEntity> patientEntityRepository;
  private Repository<AppointmentEntity> appointmentEntityRepository;

  public CreateAppoimentCommand() {
    this.patientEntityRepository = new PatientRepository(new PatientDataManagement());
    this.doctorEntityRepository = new DoctorRepository(new DoctorDataManagement());
    this.appointmentEntityRepository = new AppoimentRepository(new AppoimentDataManagement());
  }

  @Override
  public Integer call() throws Exception {

    var doctor = this.doctorEntityRepository.findById(doctorId);
    var patient = this.patientEntityRepository.findById(patientId);

    var appoiment = new AppointmentEntity(doctor, patient);
    this.appointmentEntityRepository.save(appoiment);
    return 1;
  }
}
