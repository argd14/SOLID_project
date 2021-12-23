package com.kodigo.solid.services.doctor;

import com.kodigo.solid.data.repositories.Repository;
import com.kodigo.solid.entities.ConsultationEntity;

import java.util.List;

public class ConsultationService implements IConsultationService {
  Repository<ConsultationEntity> consultationRepository;

  public ConsultationService(Repository<ConsultationEntity> consultationRepository) {
    this.consultationRepository = consultationRepository;
  }

  @Override
  public ConsultationEntity createConsultation(ConsultationEntity consultation) {
    return this.consultationRepository.save(consultation);
  }

  @Override
  public List<ConsultationEntity> getAllConsults() {
    return this.consultationRepository.findAll();
  }
}
