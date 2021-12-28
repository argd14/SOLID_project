package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.ConsultationSheetEntity;
import com.kodigo.solid.entities.Entity;

import java.io.IOException;
import java.util.List;

public class ConsultationSheetDataManagement extends CoreDataManagement<ConsultationSheetEntity>
    implements SourceData<ConsultationSheetEntity> {
  private String fileName = "consultationSheetData.ser";

  @Override
  public List<Entity<ConsultationSheetEntity>> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<Entity<ConsultationSheetEntity>> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws IOException, ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
