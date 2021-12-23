package com.kodigo.solid.services.doctor;

import com.kodigo.solid.entities.ConsultationEntity;

import java.util.List;

public interface IConsultationService {
  ConsultationEntity createConsultation(ConsultationEntity consultation);

  List<ConsultationEntity> getAllConsults();
}
