package com.kodigo.solid.datav1.fakedb;

import com.kodigo.solid.entitiesv1.DoctorEntity;

import java.io.File;
import java.util.List;

public class DoctorDataManagement extends CoreDataManagement<DoctorEntity>
    implements SourceData<DoctorEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/datav1/fakedb/doctorData.txt").getAbsolutePath();

  @Override
  public List<DoctorEntity> getDataFromTextFileDatabase() throws ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<DoctorEntity> dataToSave)
      throws ClassNotFoundException {
    this.writeInDatabase(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
