package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.Entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DoctorDataManagement extends CoreDataManagement<DoctorEntity>
    implements SourceData<DoctorEntity> {
  private String fileName =
      new File("src/main/java/com/kodigo/solid/data/fakedb/doctorData.txt").getAbsolutePath();

  @Override
  public List<Entity<DoctorEntity>> getDataFromTextFileDatabase()
      throws IOException, ClassNotFoundException {
    return this.readData(this.fileName);
  }

  @Override
  public void saveDataToTextFileDatabase(List<Entity<DoctorEntity>> dataToSave)
      throws IOException, ClassNotFoundException {
    this.writeData(dataToSave, this.fileName);
  }

  @Override
  public int getElementsCount() throws IOException, ClassNotFoundException {
    return this.getNumberOfRecords(this.fileName);
  }
}
