package com.kodigo.solid.datav1.services;

import com.kodigo.solid.datav1.repositories.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetAllCurrentUsersService<UserEntity> implements IGetAllCurrentUsers<UserEntity> {

  private Repository<UserEntity> doctorRepository;
  private Repository<UserEntity> patientEntityRepository;

  public GetAllCurrentUsersService(
      Repository<UserEntity> doctorRepository, Repository<UserEntity> patientEntityRepository) {
    this.doctorRepository = doctorRepository;
    this.patientEntityRepository = patientEntityRepository;
  }

  @Override
  public List<UserEntity> getAllCurrentUsers() throws IOException, ClassNotFoundException {
    var doctors = this.patientEntityRepository.findAll();
    var patients = this.patientEntityRepository.findAll();
    return Stream.concat(doctors.stream(), patients.stream()).collect(Collectors.toList());
  }
}
