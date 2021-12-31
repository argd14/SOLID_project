package com.kodigo.solid.datav1.fakedb;

import com.kodigo.solid.entitiesv1.AppointmentEntity;

import java.io.File;
import java.util.List;

public class AppoimentDataManagement extends CoreDataManagement<AppointmentEntity>
    implements SourceData<AppointmentEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/datav1/fakedb/appoimentData.txt").getAbsolutePath();

  @Override
  public List<AppointmentEntity> getDataFromTextFileDatabase() throws ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<AppointmentEntity> dataToSave)
      throws ClassNotFoundException {
    this.writeInDatabase(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
