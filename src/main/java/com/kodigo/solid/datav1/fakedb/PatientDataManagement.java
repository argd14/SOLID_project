package com.kodigo.solid.datav1.fakedb;

import com.kodigo.solid.entitiesv1.PatientEntity;

import java.io.File;
import java.util.List;

public class PatientDataManagement extends CoreDataManagement<PatientEntity>
    implements SourceData<PatientEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/datav1/fakedb/patientData.txt").getAbsolutePath();

  @Override
  public List<PatientEntity> getDataFromTextFileDatabase() throws ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<PatientEntity> dataToSave)
      throws ClassNotFoundException {
    this.writeInDatabase(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
