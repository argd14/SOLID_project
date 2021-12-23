package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.PatientEntity;

import java.io.IOException;
import java.util.List;

public class PatientDataManagement extends CoreDataManagement<PatientEntity>
    implements SourceData<PatientEntity> {
  private String fileName = "patientData.ser";

  @Override
  public List<PatientEntity> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<PatientEntity> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }
}
