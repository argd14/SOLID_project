package com.kodigo.solid.datav1.fakedb;

import com.kodigo.solid.entitiesv1.ConsultationEntity;

import java.io.File;
import java.util.List;

public class ConsultationDataManagement extends CoreDataManagement<ConsultationEntity>
    implements SourceData<ConsultationEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/datav1/fakedb/consultsData.txt").getAbsolutePath();

  @Override
  public List<ConsultationEntity> getDataFromTextFileDatabase() throws ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<ConsultationEntity> dataToSave)
      throws ClassNotFoundException {
    this.writeInDatabase(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
