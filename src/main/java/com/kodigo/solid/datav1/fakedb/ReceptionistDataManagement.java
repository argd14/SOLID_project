package com.kodigo.solid.datav1.fakedb;

import com.kodigo.solid.entitiesv1.ReceptionistEntity;

import java.io.File;
import java.util.List;

public class ReceptionistDataManagement extends CoreDataManagement<ReceptionistEntity>
    implements SourceData<ReceptionistEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/datav1/fakedb/receptionistData.txt")
          .getAbsolutePath();

  @Override
  public List<ReceptionistEntity> getDataFromTextFileDatabase() throws ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<ReceptionistEntity> dataToSave)
      throws ClassNotFoundException {
    this.writeInDatabase(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
