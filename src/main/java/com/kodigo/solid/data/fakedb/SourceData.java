package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.Entity;

import java.io.IOException;
import java.util.List;

public interface SourceData<T> {
  List<Entity<T>> getDataFromTextFileDatabase() throws IOException, ClassNotFoundException;

  void saveDataToTextFileDatabase(List<Entity<T>> dataToSave)
      throws IOException, ClassNotFoundException;

  int getElementsCount() throws IOException, ClassNotFoundException;
}
