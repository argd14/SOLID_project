package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.Entity;
import com.kodigo.solid.entities.PatientEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PatientDataManagement extends CoreDataManagement<PatientEntity>
    implements SourceData<PatientEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/data/fakedb/patientData.txt").getAbsolutePath();

  @Override
  public List<Entity<PatientEntity>> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<Entity<PatientEntity>> dataToSave)
      throws ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
