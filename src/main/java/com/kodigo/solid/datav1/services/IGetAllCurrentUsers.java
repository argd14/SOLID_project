package com.kodigo.solid.datav1.services;

import java.io.IOException;
import java.util.List;

public interface IGetAllCurrentUsers<T> {
  List<T> getAllCurrentUsers() throws IOException, ClassNotFoundException;
}
