package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.Entity;
import com.kodigo.solid.entities.ReceptionistEntity;

import java.io.IOException;
import java.util.List;

public class ReceptionistDataManagement extends CoreDataManagement<ReceptionistEntity>
    implements SourceData<ReceptionistEntity> {
  private String fileName = "receptionistData.ser";

  @Override
  public List<Entity<ReceptionistEntity>> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<Entity<ReceptionistEntity>> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws IOException, ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
