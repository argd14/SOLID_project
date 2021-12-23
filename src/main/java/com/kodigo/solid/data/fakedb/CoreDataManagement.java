package com.kodigo.solid.data.fakedb;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoreDataManagement<T> {

  protected List<T> readData(String pathToRead) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(pathToRead);
    ObjectInputStream ois = new ObjectInputStream(fis);
    ois.close();

    return (List<T>) ois.readObject();
  }

  protected void writeData(List dataToSave, String pathDestiny)
      throws IOException, ClassNotFoundException {
    FileOutputStream fos = new FileOutputStream(pathDestiny);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    List<T> oldData = this.readData(pathDestiny);
    List<T> newDataToSave =
        (List<T>) Stream.concat(dataToSave.stream(), oldData.stream()).collect(Collectors.toList());
    oos.writeObject(newDataToSave);
    oos.close();
  }
}
