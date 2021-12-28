package com.kodigo.solid.commands.doctor;

import com.kodigo.solid.data.fakedb.AppoimentDataManagement;
import com.kodigo.solid.data.fakedb.ConsultationDataManagement;
import com.kodigo.solid.data.repositories.AppoimentRepository;
import com.kodigo.solid.data.repositories.ConsultationRepository;
import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.ConsultationEntity;
import picocli.CommandLine;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "createConsultation")
public class CreateConsultationCommand implements Callable<Integer> {

  private Repository<ConsultationEntity> consultationEntityRepository;
  private Repository<AppointmentEntity> appointmentEntityRepository;

  public CreateConsultationCommand() {
    this.consultationEntityRepository =
        new ConsultationRepository(new ConsultationDataManagement());
    this.appointmentEntityRepository = new AppoimentRepository(new AppoimentDataManagement());
  }

  @Override
  public Integer call() throws Exception {

    int appoimentNumbers = this.appointmentEntityRepository.count();

    if (appoimentNumbers == 0) {
      System.out.println("No existen citas registradas");
      return 1;
    }

    System.out.print("Citas disponibles >");
    this.appointmentEntityRepository.findAll().stream().forEach(System.out::println);


    Scanner input = new Scanner(System.in);
    System.out.print("Id de cita a registrar");
    int appoimentId = input.nextInt();
    var appoiment = this.appointmentEntityRepository.findById(appoimentId);
    System.out.print("Fecha de consulta (yyyy-mm-dd) >");
    String consultationDate = input.nextLine();

    var consultation = new ConsultationEntity(appoiment, LocalDate.parse(consultationDate));

    this.consultationEntityRepository.save(consultation);

    return 1;
  }
}
