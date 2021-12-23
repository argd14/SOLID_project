package com.kodigo.solid.data.fakedb;

import java.io.IOException;
import java.util.List;

public interface SourceData<T> {
  List<T> getDataFromTextFileDatabase() throws IOException, ClassNotFoundException;

  void saveDataToTextFileDatabase(List<T> dataToSave) throws IOException, ClassNotFoundException;
}
