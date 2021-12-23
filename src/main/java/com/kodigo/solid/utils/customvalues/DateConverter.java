package com.kodigo.solid.utils.customvalues;

import com.beust.jcommander.IStringConverter;

import java.time.LocalDate;

public class DateConverter implements IStringConverter<LocalDate> {

  @Override
  public LocalDate convert(String value) {
    return LocalDate.parse(value);
  }
}
