package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.ConsultationDataManagement;
import com.kodigo.solid.entities.ConsultationEntity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ConsultationRepository implements Repository<ConsultationEntity> {
  private ConsultationDataManagement database;

  public ConsultationRepository(ConsultationDataManagement database) {
    this.database = database;
  }

  @Override
  public List<ConsultationEntity> findAll() {
    List<ConsultationEntity> data = null;
    try {
      data.addAll(this.database.getDataFromTextFileDatabase());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public ConsultationEntity findById(int id) {
    return null;
  }

  @Override
  public ConsultationEntity save(ConsultationEntity data) {

    try {
      this.database.saveDataToTextFileDatabase(Arrays.asList(data));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public boolean deleteById(int id) {
    return false;
  }
}
