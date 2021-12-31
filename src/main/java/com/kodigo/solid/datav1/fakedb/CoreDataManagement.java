package com.kodigo.solid.datav1.fakedb;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoreDataManagement<T> {

  protected List<T> readData(String pathToRead) throws ClassNotFoundException {

    try {

      FileInputStream fis = new FileInputStream(pathToRead);
      ObjectInputStream file = new ObjectInputStream(fis);
      List<T> data = (List<T>) file.readObject();
      file.close();
      fis.close();
      return data;
    } catch (EOFException e) {
      return null;
    } catch (IOException e) {

      return Collections.emptyList();
    }
  }

  protected void writeInDatabase(List<T> dataToSave, String pathDestiny)
      throws ClassNotFoundException {
    if (this.getNumberOfRecords(pathDestiny) > 0) {
      var oldData = this.readData(pathDestiny);

      this.writeOnTextFile(
          Stream.concat(oldData.stream(), dataToSave.stream()).collect(Collectors.toList()),
          pathDestiny);
      return;
    }
    this.writeOnTextFile(dataToSave, pathDestiny);
  }

  private void writeOnTextFile(List<T> dataToSave, String pathDestiny) {
    try {

      FileOutputStream fos = new FileOutputStream(pathDestiny);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(dataToSave);
      oos.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int getNumberOfRecords(String pathFile) throws ClassNotFoundException {
    var data = this.readData(pathFile);
    System.out.println("datak" + data);
    return data == null ? 0 : data.size();
  }
  ;
}
