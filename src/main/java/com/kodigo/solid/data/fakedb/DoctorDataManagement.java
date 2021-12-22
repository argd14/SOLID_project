package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.DoctorEntity;

import java.io.IOException;
import java.util.List;

public class DoctorDataManagement extends CoreDataManagement<DoctorEntity> {
  String fileName = "doctorData.ser";
  private SourceData<DoctorEntity> usersDatabase;
  private List<DoctorEntity> data;

  public DoctorDataManagement(SourceData<DoctorEntity> dataSystem)
      throws IOException, ClassNotFoundException {
    this.usersDatabase = dataSystem;
  }

  public List<DoctorEntity> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.usersDatabase.readData(this.fileName);
  }
}
