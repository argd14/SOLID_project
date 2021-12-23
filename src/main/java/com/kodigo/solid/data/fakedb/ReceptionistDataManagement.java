package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.ReceptionistEntity;

import java.io.IOException;
import java.util.List;

public class ReceptionistDataManagement extends CoreDataManagement<ReceptionistEntity>
    implements SourceData<ReceptionistEntity> {
  private String fileName = "receptionistData.ser";

  @Override
  public List<ReceptionistEntity> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<ReceptionistEntity> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }
}
