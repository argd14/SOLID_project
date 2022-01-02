package com.kodigo.solid.database;

import com.kodigo.solid.entities.AppointmentEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    public List<AppointmentEntity> getAppoiments() {
        var appoiment1 = new AppointmentEntity(1, LocalDate.now(), LocalTime.now());
        var appoiment2 = new AppointmentEntity(2, LocalDate.now(), LocalTime.now());
        var appoiment3 = new AppointmentEntity(3, LocalDate.now(), LocalTime.now());
        var appoiment4 = new AppointmentEntity(4, LocalDate.now(), LocalTime.now());

        return Stream.of(appoiment1, appoiment2, appoiment3, appoiment4).collect(Collectors.toList());
    }
}
