package com.kodigo.solid.datav1.fakedb;

import com.kodigo.solid.entitiesv1.ConsultationSheetEntity;

import java.io.File;
import java.util.List;

public class ConsultationSheetDataManagement extends CoreDataManagement<ConsultationSheetEntity>
    implements SourceData<ConsultationSheetEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/datav1/fakedb/consultationSheetData.txt")
          .getAbsolutePath();

  @Override
  public List<ConsultationSheetEntity> getDataFromTextFileDatabase() throws ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<ConsultationSheetEntity> dataToSave)
      throws ClassNotFoundException {
    this.writeInDatabase(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
