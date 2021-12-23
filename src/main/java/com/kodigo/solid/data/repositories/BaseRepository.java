package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseRepository<T> implements Repository<T> {
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
    T user = null;
    try {
      user =
          this.database.getDataFromTextFileDatabase().stream()
              .filter(patient -> patient.getId() == id)
              .collect(Collectors.toList())
              .get(0);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public T save(T data) {
    try {
      this.database.saveDataToTextFileDatabase(Arrays.asList(data));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public boolean deleteById(int id) {
    T user = null;
    try {
      user =
          this.database.getDataFromTextFileDatabase().stream()
              .filter(patient -> patient.getId() == id)
              .collect(Collectors.toList())
              .get(0);
      if (user == null) {
        return false;
      }
      // Si el usuario existe en la base de datos filtramos todos los usuarios diferentes y
      // reescribimos el archivo de texto
      this.database.saveDataToTextFileDatabase(
          this.database.getDataFromTextFileDatabase().stream()
              .filter(patientEntity -> patientEntity.getId() != id)
              .collect(Collectors.toList()));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return true;
  }
}
