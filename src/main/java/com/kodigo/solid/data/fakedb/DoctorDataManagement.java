package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.DoctorEntity;

import java.io.IOException;
import java.util.List;

public class DoctorDataManagement extends CoreDataManagement<DoctorEntity>
    implements SourceData<DoctorEntity> {
  String fileName = "doctorData.ser";

  @Override
  public List<DoctorEntity> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<DoctorEntity> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }
}
