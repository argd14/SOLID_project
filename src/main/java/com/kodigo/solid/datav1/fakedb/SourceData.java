package com.kodigo.solid.datav1.fakedb;

import java.io.IOException;
import java.util.List;

public interface SourceData<T> {
  List<T> getDataFromTextFileDatabase() throws IOException, ClassNotFoundException;

  void saveDataToTextFileDatabase(List<T> dataToSave) throws IOException, ClassNotFoundException;

  int getElementsCount() throws IOException, ClassNotFoundException;
}
