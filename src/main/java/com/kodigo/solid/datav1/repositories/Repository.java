package com.kodigo.solid.datav1.repositories;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
  List<T> findAll() throws IOException, ClassNotFoundException;

  T findById(int id);

  T save(T data);

  List<T> save(List<T> data);

  boolean deleteById(int id);

  int count() throws IOException, ClassNotFoundException;
}
