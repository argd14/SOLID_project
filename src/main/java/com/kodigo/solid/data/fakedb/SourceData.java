package com.kodigo.solid.data.fakedb;

import java.io.IOException;
import java.util.List;

public interface SourceData<T> {
  List<T> readData(String pathToRead) throws IOException, ClassNotFoundException;

  void writeData(List dataToSave, String pathDestiny) throws IOException, ClassNotFoundException;
}
