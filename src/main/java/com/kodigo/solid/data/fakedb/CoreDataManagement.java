package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.Entity;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoreDataManagement<T> {

  protected List<Entity<T>> readData(String pathToRead) throws ClassNotFoundException {

    try {

      FileInputStream fis = new FileInputStream(pathToRead);
      ObjectInputStream file = new ObjectInputStream(fis);

      List<Entity<T>> data = (List<Entity<T>>) file.readObject();

      file.close();
      fis.close();
      return data;
    } catch (EOFException e) {
      System.out.println("CoreManagement / Read1");

      return null;
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("CoreManagement / Read2");
      return Collections.emptyList();
    }
  }

  protected void writeData(List<Entity<T>> dataToSave, String pathDestiny)
      throws ClassNotFoundException {
    if (this.getNumberOfRecords(pathDestiny) > 0) {
      var oldData = this.readData(pathDestiny);

      this.write(
          Stream.concat(oldData.stream(), dataToSave.stream()).collect(Collectors.toList()),
          pathDestiny);
      return;
    }
    this.write(dataToSave, pathDestiny);
  }

  private List<Entity<T>> write(List<Entity<T>> dataToSave, String pathDestiny) {
    try {

      FileOutputStream fos = new FileOutputStream(pathDestiny);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(dataToSave);
      oos.close();
      fos.close();

    } catch (IOException e) {
      System.out.println("Primer Usuario");
    } catch (Exception e) {
      System.out.println("writing");
    }
    return dataToSave;
  }

  public int getNumberOfRecords(String pathFile) throws ClassNotFoundException {
    var data = this.readData(pathFile);
    System.out.println("datak" + data);
    return data == null ? 0 : data.size();
  }
  ;
}
