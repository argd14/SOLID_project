package com.kodigo.solid.data.repositories;

import com.kodigo.solid.entities.Entity;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
  List<Entity<T>> findAll() throws IOException, ClassNotFoundException;

  Entity<T> findById(int id);

  Entity<T> save(Entity<T> data);

  boolean deleteById(int id);

  int count() throws IOException, ClassNotFoundException;
}
