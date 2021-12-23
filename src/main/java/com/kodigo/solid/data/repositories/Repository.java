package com.kodigo.solid.data.repositories;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
  List<T> findAll() throws IOException, ClassNotFoundException;

  T findById(int id);

  T save(T data);

  boolean deleteById(int id);
}
