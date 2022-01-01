package com.kodigo.solid.datav1.repositories;

import com.kodigo.solid.datav1.fakedb.SourceData;
import com.kodigo.solid.entitiesv1.BaseEntity;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseRepository<T extends BaseEntity> implements Repository<T> {
  private SourceData<T> database;

  public BaseRepository(SourceData<T> database) {
    this.database = database;
  }

  @Override
  public List<T> findAll() throws IOException, ClassNotFoundException {
    return this.database.getDataFromTextFileDatabase();
  }

  @Override
  public T findById(int id) {
    T data = null;
    try {
      data =
          this.database.getDataFromTextFileDatabase().stream()
              .filter(patient -> patient.getId() == id)
              .collect(Collectors.toList())
              .get(0);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public T save(T data) {
    try {
      List<T> dataToList = Stream.of(data).collect(Collectors.toList());
      this.database.saveDataToTextFileDatabase(dataToList);
      return data;
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public boolean deleteById(int id) {
    T data = null;
    try {
      data =
          this.database.getDataFromTextFileDatabase().stream()
              .filter(patient -> patient.getId() == id)
              .collect(Collectors.toList())
              .get(0);
      if (data == null) {
        return false;
      }
      // Si el usuario existe en la base de datos filtramos todos los usuarios diferentes y
      // reescribimos el archivo de texto
      this.database.saveDataToTextFileDatabase(
          this.database.getDataFromTextFileDatabase().stream()
              .filter(entity -> entity.getId() != id)
              .collect(Collectors.toList()));
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return true;
  }

  @Override
  public int count() throws IOException, ClassNotFoundException {
    return this.database.getElementsCount();
  }
}
