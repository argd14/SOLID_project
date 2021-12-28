package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.ConsultationEntity;
import com.kodigo.solid.entities.Entity;

import java.io.IOException;
import java.util.List;

public class ConsultationDataManagement extends CoreDataManagement<ConsultationEntity>
    implements SourceData<ConsultationEntity> {
  private String fileName = "consultsData.ser";

  @Override
  public List<Entity<ConsultationEntity>> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<Entity<ConsultationEntity>> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws IOException, ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
