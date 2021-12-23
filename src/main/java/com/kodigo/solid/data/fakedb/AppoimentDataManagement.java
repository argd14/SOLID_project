package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.AppointmentEntity;

import java.io.IOException;
import java.util.List;

public class AppoimentDataManagement extends CoreDataManagement<AppointmentEntity> {
  private String fileName = "appoimentData.ser";

  public List<AppointmentEntity> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  public void saveDataToTextFileDatabase(List<AppointmentEntity> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }
}
