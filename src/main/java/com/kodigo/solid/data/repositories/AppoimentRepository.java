package com.kodigo.solid.data.repositories;

import com.kodigo.solid.entities.AppointmentEntity;

import java.io.IOException;
import java.util.List;

public class AppoimentRepository implements Repository<AppointmentEntity> {

  @Override
  public List<AppointmentEntity> findAll() throws IOException, ClassNotFoundException {
    return null;
  }

  @Override
  public AppointmentEntity findById(int id) {
    return null;
  }

  @Override
  public AppointmentEntity save(AppointmentEntity data) {
    return null;
  }

  @Override
  public boolean deleteById(int id) {
    return false;
  }
}
