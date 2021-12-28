package com.kodigo.solid.data.repositories;

import com.kodigo.solid.data.fakedb.SourceData;
import com.kodigo.solid.entities.Entity;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseRepository<T> implements Repository<T> {
  private SourceData<T> database;

  public BaseRepository(SourceData<T> database) {
    this.database = database;
  }

  @Override
  public List<Entity<T>> findAll() throws IOException, ClassNotFoundException {
    return this.database.getDataFromTextFileDatabase();
  }

  @Override
  public Entity<T> findById(int id) {
    Entity<T> data = null;
    try {
      data =
          this.database.getDataFromTextFileDatabase().stream()
              .filter(patient -> patient.getId() == id)
              .collect(Collectors.toList())
              .get(0);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public Entity<T> save(Entity<T> data) {
    try {
      List<Entity<T>> dataToList = Stream.of(data).collect(Collectors.toList());
      this.database.saveDataToTextFileDatabase(dataToList);
      System.out.println("pass");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public boolean deleteById(int id) {
    Entity<T> data = null;
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
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return true;
  }
}
